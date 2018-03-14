package com.jshx.telecomsz.platform.security.extend;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义Spring Security认证对象，增加验证码提交和图片码获取
 * Created with Intellij IDEA by 王金 on 2017/4/1 下午9:54.
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

    /**
     * 输入的校验码
     */
    private String validCode;
    /**
     * 生成的图片校验码
     */
    private String imageCode;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        // 从request中获取用户输入的验证码值
        this.validCode = request.getParameter("validCode");
        // 从session中获取图形验证码值
        this.imageCode = (String) request.getSession().getAttribute("kaptcha");
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }
}
