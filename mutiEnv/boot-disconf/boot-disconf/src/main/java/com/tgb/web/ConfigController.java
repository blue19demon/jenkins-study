package com.tgb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.tgb.disconf.prop.MQConfig;
import com.tgb.disconf.prop.MysqlConfig;
import com.tgb.disconf.prop.ZKConfig;

@RestController
@RequestMapping("/platfrorm")
public class ConfigController {

	@Autowired
	private MysqlConfig mysqlConfig;
	
	@Autowired
	private MQConfig MQConfig;
	
	@Autowired
	private ZKConfig ZKConfig;
	
	
	@RequestMapping("/mysqlConfig")
	@ResponseBody
	public MysqlConfig mysqlConfig() {
		return mysqlConfig;
	}
	
	@RequestMapping("/config")
	public String config() {
		return "DBConfig:<br>"+JSON.toJSONString(mysqlConfig,true)
		        .concat("<br>")
				.concat("MQConfig:<br>"+JSON.toJSONString(MQConfig,true))
				.concat("<br>")
				.concat("ZKConfig:<br>"+JSON.toJSONString(ZKConfig,true));
	}
}
