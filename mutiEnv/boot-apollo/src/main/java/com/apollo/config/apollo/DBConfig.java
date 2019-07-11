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
@EnableApolloConfig("TEST1.datasource")
public class DBConfig implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 动态配置从esb config读取
	@Value("${db.url}")
	private String url;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;

	@Value("${db.driverClassName}")
	private String driverClassName;

	/**
	 * @ApolloConfig用来自动注入Config对象
	 */
	/*
	 * @ApolloConfig("TEST1.datasource")
	 * 
	 * @JsonIgnore private Config config;
	 * 
	 *//**
		 * @ApolloConfigChangeListener用来自动注册ConfigChangeListener
		 *//*
			 * @ApolloConfigChangeListener("TEST1.datasource") private void
			 * someOnChange(ConfigChangeEvent changeEvent) {
			 * changeEvent.changedKeys().forEach(key ->{ ConfigChange change =
			 * changeEvent.getChange(key); System.out.println(String.
			 * format("Found datasource change - key: %s, oldValue: %s, newValue: %s, changeType: %s"
			 * , change.getPropertyName(), change.getOldValue(), change.getNewValue(),
			 * change.getChangeType())); }); }
			 */
}
