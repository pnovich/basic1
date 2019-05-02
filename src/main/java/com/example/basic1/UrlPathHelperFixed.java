package com.example.basic1;

import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;

public class UrlPathHelperFixed extends UrlPathHelper {

    public UrlPathHelperFixed() {
        super.setUrlDecode(false);
    }

    @Override
    public void setUrlDecode(boolean urlDecode) {
        if (urlDecode) {
            throw new IllegalArgumentException("Handler [" + UrlPathHelperFixed.class.getName() + "] does not support URL decoding.");
        }
    }

    @Override
    public String getServletPath(HttpServletRequest request) {
        String servletPath = getOriginatingServletPath(request);
        return servletPath;
    }

    @Override
    public String getOriginatingServletPath(HttpServletRequest request) {
        String servletPath = request.getRequestURI().substring(request.getContextPath().length());
        return servletPath;
    }
}