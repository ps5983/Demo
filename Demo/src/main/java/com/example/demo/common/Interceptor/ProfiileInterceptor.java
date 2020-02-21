package com.example.demo.common.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ProfiileInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		long startTime = System.currentTimeMillis();

		request.setAttribute("inter.startTime", startTime);// afterCompletion에 넘기기위해 request에 담ㅁ라서 보냄
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {// 나갈때
		long startTime = (Long) request.getAttribute("inter.startTime");

		long duration = System.currentTimeMillis() - startTime;

	}
}