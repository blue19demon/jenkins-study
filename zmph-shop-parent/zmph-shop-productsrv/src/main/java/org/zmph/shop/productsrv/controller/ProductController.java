package org.zmph.shop.productsrv.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;
import org.zmph.shop.api.response.ProductResponse;
import org.zmph.shop.api.ws.ProductWSFeign;
@RestController
public class ProductController implements ProductWSFeign{

	@Override
	public ProductResponse get(Integer id) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setId(id);
		productResponse.setDate(new Date());
		productResponse.setName(UUID.randomUUID().toString());
		return productResponse;
	}

}
