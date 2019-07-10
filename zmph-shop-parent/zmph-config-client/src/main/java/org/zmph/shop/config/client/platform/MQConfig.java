package org.zmph.shop.config.client.platform;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;
@ToString
@Component
@Data
@ConfigurationProperties(prefix = "mq")
@RefreshScope
public class MQConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serverUrl;
	private String userName;
	private String password;
	
	
}
