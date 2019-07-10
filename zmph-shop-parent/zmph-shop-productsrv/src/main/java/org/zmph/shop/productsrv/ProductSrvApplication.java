package org.zmph.shop.productsrv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringCloudApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("org.zmph.shop.productsrv.mapper")
public class ProductSrvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductSrvApplication.class, args);
	}
}
