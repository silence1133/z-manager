package cn.zxy.zmanager.support;

/**
 * 权限等级
 */
public interface AuthorityGroup {


    /**
     * 系统管理在内的权限范围1
     */
    int S = 1 << 1;
    /**
     * 普通职员访问的权限范围2
     */
    int A = 1 << 2;

    /**
     * 管理员能访问的权限范围
     */
    int S_A = 1 << 1 | 1 << 2;

}
