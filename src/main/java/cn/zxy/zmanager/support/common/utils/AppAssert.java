package cn.zxy.zmanager.support.common.utils;


import cn.zxy.zmanager.support.common.ResultCode;
import cn.zxy.zmanager.support.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 * 校验工具类(保持校验逻辑，可新增)
 * Created by 000730 on 2017/6/5.
 */
public class AppAssert {

    /**
     * 判断object,为null，""," "
     *
     * @param resultCode 异常信息
     * @param object     判断参数
     */
    public static void judgeNull(ResultCode resultCode, Object... object) {
        if (object == null) {
            throw new BizException(resultCode);
        }
        for (Object ob : object) {
            if (ob == null) {
                throw new BizException(resultCode);
            }
            if (ob instanceof String && ((String) ob).trim().length() == 0) {
                throw new BizException(resultCode);
            }
        }
    }

    /**
     * if {@code left} > {@code right} throw BizException
     *
     * @param resultCode 异常信息
     * @param left       判断参数
     * @param right      判断参数
     */
    public static void judgeGreater(ResultCode resultCode, Integer left, Integer right) {
        if (left.compareTo(right) > 0) {
            throw new BizException(resultCode);
        }
    }

    public static void judgeGreater(ResultCode resultCode, Float left, Float right) {
        if (left.compareTo(right) > 0) {
            throw new BizException(resultCode);
        }
    }

    public static void judgeGreater(ResultCode resultCode, Double left, Double right) {
        if (left.compareTo(right) > 0) {
            throw new BizException(resultCode);
        }
    }
    
    public static void judgeGreater(ResultCode resultCode, Long left, Long right) {
        if (left.compareTo(right) > 0) {
            throw new BizException(resultCode);
        }
    }

    /**
     * if {@code left} == {@code right} throw BizException
     *
     * @param resultCode 异常信息
     * @param left       判断参数
     * @param right      判断参数
     */
    public static void judgeEqual(ResultCode resultCode, Object left, Object right) {
        if (Objects.equals(left, right)) {
            throw new BizException(resultCode);
        }
    }

    /**
     * if {@code left} != {@code right} throw BizException
     *
     * @param resultCode 异常信息
     * @param left       判断参数
     * @param right      判断参数
     */
    public static void judgeUnequal(ResultCode resultCode, Object left, Object right) {
        if (!Objects.equals(left, right)) {
            throw new BizException(resultCode);
        }
    }

    /**
     * if {@code left} before {@code right} throw BizException
     *
     * @param resultCode 异常信息
     * @param left       判断参数
     * @param right      判断参数
     */
    public static void judgeDateBefore(ResultCode resultCode, Date left, Date right) {
        if (left.before(right)) {
            throw new BizException(resultCode);
        }
    }

    /**
     * if {@code str} not match {@code reg} throw BizException
     *
     * @param resultCode
     * @param reg
     * @param reg
     */
    public static void judgeRegular(ResultCode resultCode, String reg, String... strArr) {
        if (strArr == null || StringUtils.isBlank(reg)) {
            throw new BizException(resultCode);
        }
        for (String str : strArr) {
            if (!str.matches(reg)) {
                throw new BizException(resultCode);
            }
        }
    }

    /**
     * if {@code str} is not Number throw BizException
     *
     * @param resultCode
     * @param strArr
     */
    public static void judgeNumber(ResultCode resultCode, String... strArr) {
        if (strArr == null) {
            throw new BizException(resultCode);
        }
        for (String str : strArr) {
            if (!NumberUtils.isNumber(str)) {
                throw new BizException(resultCode);
            }
        }
    }
    
    /**
     * if {@code flag} is true throw BizException
     *
     * @param resultCode 异常信息
     * @param flag       
     */
    public static void judgeTrue(ResultCode resultCode, boolean flag) {
        if (flag) {
            throw new BizException(resultCode);
        }
    }

    /**
     * if {@code flag} is false throw BizException
     *
     * @param resultCode 异常信息
     * @param flag
     */
    public static void judgeFalse(ResultCode resultCode, boolean flag) {
        if (!flag) {
            throw new BizException(resultCode);
        }
    }

    /**
     * if {@code collection} is null or empty throw BizException
     *
     * @param resultCode 异常信息
     * @param collection       
     */
    public static void judgeEmpty(ResultCode resultCode, Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            throw new BizException(resultCode);
        }
    }
}
