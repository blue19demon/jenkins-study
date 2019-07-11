package com.elk;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

@Service
public class UserService {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public String save(RequestData requestData) {
		requestData.setNo(UUID.randomUUID().toString().replaceAll("-", ""));
		logger.info("ELK项目，用户->" + JSON.toJSONString(requestData, true) + ",保存成功！");
		return "成功HOOT";
	}

}
