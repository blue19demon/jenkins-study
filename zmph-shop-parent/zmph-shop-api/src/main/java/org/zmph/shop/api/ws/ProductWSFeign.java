package org.zmph.shop.api.ws;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zmph.shop.api.response.ProductResponse;
@FeignClient(value = "zmph-shop-productsrv")
@RequestMapping(value = "/api-product")
public interface ProductWSFeign {
	@RequestMapping(value = "/product/get", method = RequestMethod.GET)
	public ProductResponse get(@RequestParam(value = "id") Integer id);
}
