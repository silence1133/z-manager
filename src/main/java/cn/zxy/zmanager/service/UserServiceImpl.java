package cn.zxy.zmanager.service;

import cn.zxy.zmanager.dao.dataobject.User;
import cn.zxy.zmanager.dao.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author Silence 000996
 * @data 18/9/12
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String selectUserById(Long userId) {
        log.info("test log");
        return userMapper.selectByPrimaryKey(userId).toString();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertUser(User user) {
        int result = userMapper.insertSelective(user);
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter(){
            @Override
            public void afterCommit() {
                System.out.println("Transaction is commit");
            }
        });
        return result;
    }

    @Async("asyncServiceExecutor")
    @Override
    public void testAsyncExecutor() {
        log.info("testAsyncExecutor start");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testAsyncExecutor done");
    }
}
