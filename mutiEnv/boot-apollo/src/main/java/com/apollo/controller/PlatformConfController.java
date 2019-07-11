package com.apollo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apollo.config.apollo.DBConfig;
import com.apollo.config.apollo.MQConfig;
import com.apollo.config.apollo.ZKConfig;
import com.apollo.utils.JacksonJsonMapper;

@RestController
@RequestMapping("/platfrorm")
public class PlatformConfController {

	@Autowired
	private DBConfig DBConfig;
	
	@Autowired
	private MQConfig MQConfig;
	
	@Autowired
	private ZKConfig ZKConfig;
	
	@RequestMapping("/config")
	public String config() {
		JacksonJsonMapper jacksonJsonMapper= JacksonJsonMapper.INSTANCE;
		return "DBConfig:<br>"+jacksonJsonMapper.toJson(DBConfig)
		        .concat("<br>")
				.concat("MQConfig:<br>"+jacksonJsonMapper.toJson(MQConfig))
				.concat("<br>")
				.concat("ZKConfig:<br>"+jacksonJsonMapper.toJson(ZKConfig));
	}
}
