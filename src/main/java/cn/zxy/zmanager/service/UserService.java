package cn.zxy.zmanager.service;

import cn.zxy.zmanager.dao.dataobject.User;

/**
 * @author Silence 000996
 * @data 18/9/12
 */
public interface UserService {
    String selectUserById(Long userId);

    int insertUser(User user);

    void testAsyncExecutor();
}
