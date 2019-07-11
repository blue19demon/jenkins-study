package com.apollo.bean;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PicServer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Value("${image_url:default}")
	private String imgUrlValue;

	@Value("${app_address:default}")
	private String appAddressValue;

	public String getImgUrlValue() {
		return imgUrlValue;
	}

	public void setImgUrlValue(String imgUrlValue) {
		this.imgUrlValue = imgUrlValue;
	}

	public String getAppAddressValue() {
		return appAddressValue;
	}

	public void setAppAddressValue(String appAddressValue) {
		this.appAddressValue = appAddressValue;
	}

	public PicServer() {
		super();
	}
	
}
