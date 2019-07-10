package org.zmph.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients
public class ShopWebApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ShopWebApplication.class, args);
    }
}
