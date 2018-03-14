package com.jshx.telecomsz.platform.config;

import com.jshx.telecomsz.platform.security.extend.KaptchaServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with Intellij IDEA by 王金 on 2017/4/1 下午5:21.
 */
@Configuration
public class KaptchaConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new KaptchaServlet(),
                "/images/kaptcha.jpg");
        servletRegistrationBean.addInitParameter("kaptcha.session.key", "kaptcha");
        servletRegistrationBean.addInitParameter("kaptcha.border", "no");
        return servletRegistrationBean;
    }
}
