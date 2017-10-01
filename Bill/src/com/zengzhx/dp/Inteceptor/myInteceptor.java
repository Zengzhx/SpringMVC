package com.zengzhx.dp.Inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class myInteceptor extends HandlerInterceptorAdapter {

	/**
	 * 自定义拦截器
	 * SpringMVC的拦截器HandlerInterceptorAdapter对应提供了三个preHandle，postHandle，afterCompletion方法。
	 * 
	 * 1、preHandle在业务处理器处理请求之前被调用，
	 * 2、postHandle在业务处理器处理请求执行完成后,生成视图之前执行，
	 * 3、afterCompletion在DispatcherServlet完全处理完请求后被调用,可用于清理资源等。
	 * 
	 * 所以要想实现自己的权限管理逻辑，需要继承HandlerInterceptorAdapter并重写其三个方法。
	 * 首先在springmvc.xml中加入自己定义的拦截器我的实现逻辑CommonInterceptor，
	 **/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandel");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("afterCompletion");
	}

	@Override //?????
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("afterConcurrentHandlingStarted");
	}

}
