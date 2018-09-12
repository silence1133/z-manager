package cn.zxy.zmanager.service;

import cn.zxy.zmanager.dao.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
