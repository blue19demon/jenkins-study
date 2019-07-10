package org.zmph.shop.api.ws;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zmph.shop.api.common.PageResult;
import org.zmph.shop.api.response.UserResponse;
@FeignClient(value = "zmph-shop-usersrv")
@RequestMapping(value = "/api-user")
public interface UserWSFeign {
	@RequestMapping(value = "/user/delete", method = RequestMethod.GET)
	public int deleteUser(@RequestParam(value = "id") Integer id);

	@RequestMapping(value = "/user/findUserByPage", method = RequestMethod.GET)
	public PageResult<UserResponse> findUserByPage(@RequestParam(value = "pageNow")Integer pageNow,
			@RequestParam(value = "pageSize")Integer pageSize);
	
	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public int addUser(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password, @RequestParam(value = "phone") String phone);
	
	@RequestMapping(value = "/user/update", method = RequestMethod.GET)
	public int updateUser(@RequestParam(value = "id") Integer id,@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password, @RequestParam(value = "phone") String phone);
}
