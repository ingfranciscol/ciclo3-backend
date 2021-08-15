
package com.fady.configuracion;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JwtFilter extends GenericFilterBean{

    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = JwtUtil.getAuthentication((HttpServletRequest)request);
        HttpServletResponse respo = (HttpServletResponse)response;
        respo.addHeader("Access-Control-Max-Age", "-1");
        //respo.addHeader("Access-Control-Allow-Origin", "*");
        respo.addHeader("Access-Control-Allow-Credentials", "true");
        respo.addHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,HEAD");
        respo.addHeader("Access-Control-Allow-Headers", "Authorization, Access-Control-Allow-Headers, Origin.Accept, X-Requested-Widh, Content-Type, Access-Control-Request-Method");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }   
}
