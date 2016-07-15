package com.example.web.config;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class WebConfig {

	@Bean
	public FilterRegistrationBean delegatingFilterProxy() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new DelegatingFilterProxy("springSecurityFilterChain"));
		registration.addUrlPatterns("/");
		return registration;
	}
}