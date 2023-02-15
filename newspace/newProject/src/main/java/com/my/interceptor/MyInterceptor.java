package com.my.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
	
	@SuppressWarnings("rawtypes")
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
		logger.info("getContextPath="+ request.getContextPath());
		logger.info("getServletPath="+ request.getServletPath());
		logger.info("getRequestURL="+ request.getRequestURL().toString());
		
		if("/".equals(request.getServletPath())){
			logger.info("/");
		} else {
			Enumeration names = request.getParameterNames();
	    	while(names.hasMoreElements()) {
	    		String key = (String) names.nextElement();
	    		logger.info(key + ": " + request.getParameter(key));
	    	}
		}
        
        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        
        logger.info("postHandle1");
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        
        logger.info("afterCompletion1");
    }    
}
