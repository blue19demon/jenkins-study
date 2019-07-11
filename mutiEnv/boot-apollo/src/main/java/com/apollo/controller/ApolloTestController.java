package com.apollo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apollo.bean.PicServer;
import com.apollo.constant.KesConstants;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;

@Controller
public class ApolloTestController {
	@Value("${image_url:default}")
	private String imgUrlValue;

	@Value("${app_address:default}")
	private String appAddressValue;

	@Autowired
	private PicServer picServer;
	
	@ApolloConfig
    private Config config;
	@ResponseBody
	@RequestMapping("/getConfigByApollo1")
	public String getConfigByApollo1() {
		return imgUrlValue+"<br>"+appAddressValue;
	}
	
	@ResponseBody
	@RequestMapping("/picServer")
	public PicServer picServer(){
		return picServer;
	}
	
	@ResponseBody
	@RequestMapping("/getConfigByApollo2")
	public String getConfigByApollo2(){
		return config.getProperty(KesConstants.KEYS_IMG_APPADDRESS, "default");
	}
}
