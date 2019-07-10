package org.zmph.shop.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zmph.shop.config.client.platform.JdbcFile;
import org.zmph.shop.config.client.platform.MQConfig;
import org.zmph.shop.config.client.platform.ZKConfig;

import com.alibaba.fastjson.JSON;

@RestController
public class TestController {
	
	@Autowired
	private JdbcFile jdbcConfig;
	
	@Autowired
	private MQConfig MQConfig;
	
	@Autowired
	private ZKConfig ZKConfig;
	
	
	@Value("${jdbc.url}")
	private String jdbcUrl;
	
	@RequestMapping("/config")
	public String config() {
		return "DBConfig:<br>"+JSON.toJSONString(jdbcConfig,true)
		        .concat("<br>")
				.concat("MQConfig:<br>"+JSON.toJSONString(MQConfig,true))
				.concat("<br>")
				.concat("ZKConfig:<br>"+JSON.toJSONString(ZKConfig,true));
	}
	@GetMapping("jdbcUrl")
	public String jdbcUrl() {
		return jdbcUrl;
	}
}
