package com.tgb;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
//@ImportResource({ "classpath:disconf/applicationContext.xml" })
//第二种方式 引入disconf
public class DisconfRunMain{
 
	public static void main(String args[]) {

		SpringApplication.run(DisconfRunMain.class, args);
 
	}
}
