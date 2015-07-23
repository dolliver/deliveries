package com.ciandt.challenge.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@EnableWebMvc
//@EnableTransactionManagement
//@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan(basePackages = "com.ciandt.challenge", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = RestController.class), useDefaultFilters = false)
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	}

	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		return localeResolver;
	}

	@Override
	public void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		//PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		//resolver.setPageParameterName("page.page");
		//resolver.setSizeParameterName("page.size");
		//resolver.setOneIndexedParameters(true);
		//argumentResolvers.add(resolver);
		//super.addArgumentResolvers(argumentResolvers);
	}



}
