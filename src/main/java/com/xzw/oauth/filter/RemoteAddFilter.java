package com.xzw.oauth.filter;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RemoteAddFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(req);

        String token = request.getParameter("token");
        if (!StringUtils.isEmpty(token)) {
            requestWrapper.addHeader("token", token);
            chain.doFilter(requestWrapper, response);
        }
        chain.doFilter(request, response);
    }
}
