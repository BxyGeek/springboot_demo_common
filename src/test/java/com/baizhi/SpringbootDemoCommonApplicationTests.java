package com.baizhi;

import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoCommonApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    public void test1() {
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }




    @Test
    public void test2() {
        User user = new User();
        user.setUsername("貂蝉");
        user.setId("0aa522feb9ea48419d4f3dbc5ec275d9");
        user.setAge(34);
        List<User> users = userMapper.select(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void select() {
        int bxy = userMapper.selectCount(new User("123456", "bxy", 18, new Date()));
        System.out.println(bxy);
    }






    @Test
    public void testTime() {
        Encoder encoder = new Encoder();
        File file = new File("E:\\baizhi\\后期项目\\maven\\视频\\maven引言.wmv");
        try {
            MultimediaInfo info = encoder.getInfo(file);
            long ls = info.getDuration();
            System.out.println(ls);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
