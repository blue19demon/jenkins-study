package com.tgb.disconf.prop;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
@Component
@DisconfFile(filename = "zookeeper.properties")
public class ZKConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String server;
	
	private String root;
	
	@DisconfFileItem(name = "zookeeper.server", associateField = "server")
	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}
	
	@DisconfFileItem(name = "zookeeper.root", associateField = "root")
	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}
	
	
}
