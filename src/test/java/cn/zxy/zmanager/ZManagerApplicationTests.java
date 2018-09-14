package cn.zxy.zmanager;

import cn.zxy.zmanager.dao.dataobject.User;
import cn.zxy.zmanager.dao.mapper.UserMapper;
import cn.zxy.zmanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ZManagerApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        System.out.println(userMapper.selectByPrimaryKey(1L));
    }

    @Test
    public void testTransactional() {
        User user = new User();
        user.setIsNew(true);
        user.setCreateTime(System.currentTimeMillis());
        user.setPhoneNumber("test323");
        user.setUicId(42315123233L);

        int result = userService.insertUser(user);

        Assert.assertEquals(result, 1);
    }

    @Test
    public void testAsyncExecutor() throws InterruptedException {
        userService.testAsyncExecutor();
        log.info("main done");
        Thread.sleep(10000);
    }

}
