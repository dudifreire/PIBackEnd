package com.example.backend.pi.models;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsController implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");

        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }

    // public void addCorsMappings(CorsRegistry registry) {
    // registry.addMapping("/**").allowedMethods
    // ("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");;
    // }

    /*
     * @Bean CorsConfigurationSource corsConfigurationSource(){ CorsConfiguration
     * configuration = new CorsConfiguration();
     * configuration.setAllowedOrigins(Arrays.asList("*"));
     * configuration.setAllowedMethods(Arrays.asList("GET","POST"));
     * UrlBasedCorsConfigurationSource source = new
     * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
     * configuration); return source; }
     */

}
