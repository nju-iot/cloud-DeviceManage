package com.lot.equipment.config.filter;

import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域过滤器
 */
public class CrossFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String origin = req.getHeader("Origin");
        if (!org.springframework.util.StringUtils.isEmpty(origin)) {
            res.addHeader("Access-Control-Allow-Origin", origin);
        }
        res.addHeader("Access-Control-Allow-Methods", "*");
        String headers = req.getHeader("Access-Control-Request-Headers");
        if (!org.springframework.util.StringUtils.isEmpty(headers)) {
            res.addHeader("Access-Control-Allow-Headers", headers);
        }
        res.addHeader("Access-Control-Max-Age", "3600");
        res.addHeader("Access-Control-Allow-Credentials", "true");
        if (req.getMethod().equalsIgnoreCase(RequestMethod.OPTIONS.toString())) {
            res.setStatus(200);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
