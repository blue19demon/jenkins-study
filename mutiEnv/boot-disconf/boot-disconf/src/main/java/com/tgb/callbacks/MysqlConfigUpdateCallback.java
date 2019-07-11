package com.tgb.callbacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.tgb.disconf.prop.MysqlConfig;

/**
 * 这是mysqlConfig的回调函数类
 */
//@Service
//@DisconfUpdateService(classes = {MysqlConfig.class})
public class MysqlConfigUpdateCallback implements IDisconfUpdate {


    @Autowired
    private MysqlConfig mysqlConfig;

    /**
     *
     */
    public void reload() throws Exception {
    	System.out.println("更新后："+JSONObject.toJSONString(mysqlConfig));
    }

}
