package org.zmph.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zmph.shop.api.common.PageResult;
import org.zmph.shop.api.response.ProductResponse;
import org.zmph.shop.api.response.UserResponse;
import org.zmph.shop.api.ws.ProductWSFeign;
import org.zmph.shop.api.ws.UserWSFeign;

@RestController
@RequestMapping("/web")
public class TestController {

	@Autowired
	private UserWSFeign userWSFeign;
	@Autowired
	private ProductWSFeign productWSFeign;

	@RequestMapping(value = "/product/get", method = RequestMethod.GET)
	public ProductResponse get(@RequestParam(value = "id") Integer id) {
		return productWSFeign.get(id);
	}
	
	@RequestMapping(value = "/user/delete", method = RequestMethod.GET)
	public int deleteUser(Integer id) {
		return userWSFeign.deleteUser(id);
	}

	@RequestMapping(value = "/user/findUserByPage", method = RequestMethod.GET)
	public PageResult<UserResponse> findUserByPage(Integer pageNow, Integer pageSize) {
		return userWSFeign.findUserByPage(pageNow, pageSize);
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public int addUser(String userName, String password, String phone) {
		return userWSFeign.addUser(userName, password, phone);
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.GET)
	public int updateUser(@RequestParam(value = "id") Integer id, @RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password, @RequestParam(value = "phone") String phone) {
		return userWSFeign.updateUser(id, userName, password, phone);

	}
}
