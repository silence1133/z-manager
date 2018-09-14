package cn.zxy.zmanager.configuration;

import cn.zxy.zmanager.dao.dataobject.User;
import cn.zxy.zmanager.dao.mapper.UserMapper;
import cn.zxy.zmanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ThreadPoolTaskExecutorTest {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void testThreadPoolTaskExecutor() {
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            threadPoolTaskExecutor.execute(() -> {
                try {
                    for (int j = 0; j < Integer.MAX_VALUE; j++) {
                        j--;
                    }
                    System.out.println("run " + finalI);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
