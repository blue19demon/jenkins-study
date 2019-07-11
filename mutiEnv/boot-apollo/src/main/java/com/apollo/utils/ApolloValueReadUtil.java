package com.apollo.utils;

import org.springframework.util.StringUtils;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

/**
 * 阿波罗读取
 */
@Deprecated
public class ApolloValueReadUtil {
	public static String getApolloValueByKey(String key){
		if(StringUtils.isEmpty(key)){
			return null;
		}
		Config config = ConfigService.getAppConfig();
		String defaultValue = "default02";
		return config.getProperty(key, defaultValue);
	}
	
}