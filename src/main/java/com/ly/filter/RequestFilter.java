//package com.ly.filter;
//
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.Serializable;
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.Map;
//
///**
// * Created by cilu on 2017/10/30.
// */
//@WebFilter(filterName = "requestFilter", urlPatterns = "/*")
//public class RequestFilter implements Filter {
//
//    private final Log log = LogFactory.getLog("request-time.log");
//
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        System.out.println("--------------request time filter----------");
//        System.out.println(log);
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
////        this.requestLog(1, httpRequest);
//        chain.doFilter(request, response);
//
//    }
//
//    private void requestLog(Serializable adminId, HttpServletRequest request) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(adminId);
//        sb.append("|");
//        sb.append(request.getRequestURL());
//        sb.append("|");
//        sb.append(request.getQueryString());
//        sb.append("|");
//        Map map = request.getParameterMap();
//        Iterator iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry) iterator.next();
//            sb.append(entry.getKey() + "=" + Arrays.toString((Object[]) entry.getValue()));
//            sb.append("&");
//        }
//        String loginInfo = sb.toString();
//        this.log.info(StringUtils.replaceChars(loginInfo, "\n\r", ""));
//    }
//
//    public void destroy() {
//
//    }
//}
