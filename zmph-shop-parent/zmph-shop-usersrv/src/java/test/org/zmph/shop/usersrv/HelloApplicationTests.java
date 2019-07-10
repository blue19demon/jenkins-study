package org.zmph.shop.usersrv;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zmph.shop.usersrv.mq.demo.Sender;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserSrvApplication.class)
public class HelloApplicationTests {
 
    @Autowired
    private Sender sender;
 
    @Test
    public void hello(){
        sender.send();
        sender.sendTopic();
    }
}