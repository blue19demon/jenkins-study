package org.zmph.shop.config.client.platform;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@ToString
@Component
@Data
@ConfigurationProperties(prefix = "jdbc")
@RefreshScope
public class JdbcFile {

	private String url;
	private String port;
	private String username;
	private String password;
	
}
