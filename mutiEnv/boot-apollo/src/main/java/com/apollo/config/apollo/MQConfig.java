package com.apollo.config.apollo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

import lombok.Data;
import lombok.ToString;
@ToString
@Component
@Data
@ConfigurationProperties
@EnableApolloConfig("TEST1.mq")
public class MQConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Value("${mq.serverUrl}")
	private String serverUrl;
	@Value("${mq.userName}")
	private String userName;
	@Value("${mq.password}")
	private String password;
	
	
}
