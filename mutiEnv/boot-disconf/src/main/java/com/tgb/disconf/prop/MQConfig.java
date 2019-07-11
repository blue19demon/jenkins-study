package com.tgb.disconf.prop;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
@Component
@DisconfFile(filename = "mq.properties")
public class MQConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serverUrl;
	private String userName;
	private String password;
	
	@DisconfFileItem(name = "mq.serverUrl", associateField = "serverUrl")
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	
	@DisconfFileItem(name = "mq.userName", associateField = "userName")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@DisconfFileItem(name = "mq.password", associateField = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
