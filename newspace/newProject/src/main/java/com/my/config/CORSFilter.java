package com.my.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.my.util.ComUtil;

//@Slf4j
public class CORSFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(CORSFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("init CORSFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		logger.info("##### filter - before #####");
		//chain.doFilter(req, res);
		chain.doFilter(new RequestWrapper((HttpServletRequest)req), res);
		logger.info("##### filter - after #####");
	}
	
	private static class RequestWrapper extends HttpServletRequestWrapper {
		
		public RequestWrapper(HttpServletRequest request) {
			super(request);
		}
		
		@Override
		public String[] getParameterValues(String parameter) {
			String values[] = super.getParameterValues(parameter); // 전달받은 parameter 불러오기
			
			if(values == null) {
				return null;
			}
			
			for(int i=0; i<values.length; i++) {
				if(values[i] != null) {
					try {
						//values[i] = AES.getInstance().decrypt(values[i]); // parameter 복호화
						values[i] = ComUtil.getParameter(values[i]);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			
			return values;
		}
		
		@Override
		public String getParameter(String parameter) {
			String value = super.getParameter(parameter); // 전달받은 parameter 불러오기
			
			if(value == null) {
				return null;
			}
			
			try {
				//value = AES.getInstance().decrypt(value); // parameter 복호화
				value = ComUtil.getParameter(value);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			return value;
		}
	}
	
	@Override
	public void destroy() {
		logger.info("destroy CORSFilter");
	}
}
