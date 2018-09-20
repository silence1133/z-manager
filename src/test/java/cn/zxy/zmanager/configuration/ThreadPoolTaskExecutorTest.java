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

import java.util.concurrent.CountDownLatch;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ThreadPoolTaskExecutorTest {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void testThreadPoolTaskExecutor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 4; i++) {
            int finalI = i;
            threadPoolTaskExecutor.execute(() -> {
                try {
                    for (int j = 0; j < Integer.MAX_VALUE; j++) {
                        ;
                    }
                    System.out.println("run " + finalI);
                    Thread.sleep(1000);
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolTaskExecutor.shutdown();
        System.out.println(1);
        countDownLatch.await();
    }
}
