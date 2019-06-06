package ru.bellintegrator.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ru.bellintegrator.api.interceptors.MainApiInterceptor;

@Configuration
public class MyConfig implements WebMvcConfigurer {
	
	private final MainApiInterceptor interceptor;
	
	@Autowired
	public MyConfig(MainApiInterceptor interceptor) {
		this.interceptor = interceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns("/api/*");
	}
	
}
