package com.demo.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：aiwei
 * @Description：TODO
 * @CreateDate：2019/5/31 14:09
 */
@Configuration
public class DruidConfig {

	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}

	@Bean
	public ServletRegistrationBean druidStatViewServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		Map<String, String> initParams = new HashMap<>();
		//　可配的属性都在 StatViewServlet 和其父类下
		initParams.put("loginUsername", "root");
		initParams.put("loginPassword", "root");
		servletRegistrationBean.setInitParameters(initParams);
		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean druidWebStatFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		Map<String, String> initParams = new HashMap<>();
		initParams.put("exclusions", "*.js,*.css,/druid/*");
		filterRegistrationBean.setInitParameters(initParams);
		filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
		return filterRegistrationBean;
	}
}
