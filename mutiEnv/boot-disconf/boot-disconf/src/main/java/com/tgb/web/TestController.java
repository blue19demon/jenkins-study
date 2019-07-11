package com.tgb.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tgb.bean.User;
import com.tgb.service.UserService;

@Controller
public class TestController {

	@Autowired
	private UserService userService;
	@RequestMapping("/query")
	@ResponseBody
	public List<User> test() {
		return userService.queryAll();
	}
}
