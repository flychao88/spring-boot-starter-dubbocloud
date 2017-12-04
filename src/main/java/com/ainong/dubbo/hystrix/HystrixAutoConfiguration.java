package com.ainong.dubbo.hystrix;

import com.ainong.dubbo.DubboProperties;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.HystrixConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * hystrix 配置
 * @author juntao.zhang
 * @since 0.0.0
 */

@Configuration
@EnableConfigurationProperties(DubboProperties.class)
public class HystrixAutoConfiguration {

	@Autowired
	private DubboProperties dubboProperties;

	@Bean
	public HystrixMetricsStreamServlet hystrixMetricsStreamServlet(){
		return new HystrixMetricsStreamServlet();
	}

	@Bean
	public ServletRegistrationBean registration(HystrixMetricsStreamServlet servlet){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean();
		registrationBean.setServlet(servlet);
		registrationBean.setEnabled(true);//是否启用该registrationBean
		registrationBean.addUrlMappings("/hystrix.stream");
		return registrationBean;
	}

	@Bean
	public HystrixConfig requestHystrixConfig() {
		HystrixConfig hystrixConfig = dubboProperties.getHystrix();
		if (hystrixConfig == null) {
			hystrixConfig = new HystrixConfig();
		}
		return hystrixConfig;
	}

}
