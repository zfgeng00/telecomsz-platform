package com.jshx.telecomsz.platform.security.extend;

import com.jshx.telecomsz.platform.inerface.LoginInterface;
import com.jshx.telecomsz.platform.model.PasswordErrorTimes;
import com.jshx.telecomsz.platform.model.User;
import com.jshx.telecomsz.platform.model.UserRole;
import com.jshx.telecomsz.platform.util.Consts;
import com.jshx.telecomsz.platform.util.IPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * Created with Intellij IDEA by 王金 on 2017/2/20 下午2:35.
 *
 * @author 王金
 */
@Component
public class SecurityAuthenticationProvider implements AuthenticationProvider {

    private final LoginInterface loginInterface;
    private final Environment environment;

    @Autowired
    public SecurityAuthenticationProvider(LoginInterface loginInterface, Environment environment) {
        this.loginInterface = loginInterface;
        this.environment = environment;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        CustomWebAuthenticationDetails customWebAuthenticationDetails = (CustomWebAuthenticationDetails) auth.getDetails();

        // 页面填写的账号
        String loginAccount = auth.getPrincipal().toString();
        // 页面填写的密码
        String password = auth.getCredentials().toString();
        // 用户角色列表
        Set<GrantedAuthority> authorities = new HashSet<>();

        // 校验用户登录错误次数，超过3次账号锁定30分钟
        if (Consts.loginBlackList.containsKey(loginAccount)) {
            PasswordErrorTimes passwordErrorTimes = Consts.loginBlackList.get(loginAccount);
            if (passwordErrorTimes.getCount() >= 3
                    && (System.currentTimeMillis() - passwordErrorTimes.getLastErrorTime().getTime()) / 1000 / 60 < 30) {
                throw new LockedException("登录错误超过3次，账号锁定30分钟");
            }
        }
        // 生产环境验证校验码
        if ("dist".equals(environment.getActiveProfiles()[0])) {
            if (customWebAuthenticationDetails == null || customWebAuthenticationDetails.getImageCode() == null || !customWebAuthenticationDetails.getImageCode().equals
                    (customWebAuthenticationDetails.getValidCode())) {
                throw new BadCredentialsException("验证码错误");
            }
        }

        User user;
        if (!isEmpty(loginAccount)
                && !isEmpty(password)
                && (user = loginInterface.login(loginAccount, password)) != null) {


            // 获取请求地址
            String remoteHost = ((ServletRequestAttributes) RequestContextHolder
                    .currentRequestAttributes())
                    .getRequest()
                    .getRemoteHost();

            // 登录校验通过,获取拥有角色
            if (user.getUserRoles() != null) {
                for (UserRole userRole : user.getUserRoles()) {
                    //超级管理员限制登录IP
                    if ("ROLE_ADMIN".equals(userRole.getRole().getRoleCode())) {
                        if (IPUtils.notInRange(remoteHost, "192.168.31.0/24")
                                && IPUtils.notInRange(remoteHost, "10.1.1.0/24")
                                && IPUtils.notInRange(remoteHost, "58.213.224.240/28")) {
                            throw new DisabledException("超级管理员账号不允许在外部登录");
                        }
                    }
                    authorities.add(new SimpleGrantedAuthority(userRole.getRole().getRoleCode()));
                }
            }
            

            // 认证成功后移除失败信息
            if (Consts.loginBlackList.containsKey(loginAccount)) {
                Consts.loginBlackList.remove(loginAccount);
            }
            
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                    = new UsernamePasswordAuthenticationToken(user.getName(), "", authorities);
            // 登录用户信息存入Token details
            usernamePasswordAuthenticationToken.setDetails(user);


            return usernamePasswordAuthenticationToken;
        } else {
            throw new BadCredentialsException("用户名或密码错误");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass));
    }

}
