package cn.zxy.zmanager.support.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author Silence 000996
 * @data 18/9/14
 */
@Configuration
@Slf4j
public class MainConfiguration {

    public static final int CORE_POOL_SIZE = 4;
    public static final int MAX_POOL_SIZE = 20;
    public static final int QUEUE_CAPACITY = 5000;
    public static final String THREAD_NAME_PREFIX = "z-manager-thread-";

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        threadPoolTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        //任务队列深度
        threadPoolTaskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        threadPoolTaskExecutor.setThreadNamePrefix(THREAD_NAME_PREFIX);
        //待任务处理完之后才销毁线程池（类似于jdk线程池的shutdown和shutdownNow的区别）
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        //处理不过来时的拒绝策略
        threadPoolTaskExecutor.setRejectedExecutionHandler((runnable, executor) -> {
            //
        });
        return threadPoolTaskExecutor;
    }
}
