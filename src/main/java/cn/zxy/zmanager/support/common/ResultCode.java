package cn.zxy.zmanager.support.common;



public enum ResultCode {

    SUCCESS(180100000, "操作成功"),

    FAILURE(180100001, "操作失败"),

    SERVER_ERROR(180100002,"服务器异常"),

    /* 参数错误 */
    WRONG_PARAMS(180200400, "输入参数有错"),

    /* 参数错误 */
    PARAMS_IS_NULL(180200402, "输入参数不能为空"),

    /* 参数错误 */
    WRONG_PERMISSION(180200401, "没有权限"),

    /*未知错误*/
    UNKOWN(-1, "");


    private int code;

    private String msg;

    /**
     * 结果的code
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * 结果的消息
     *
     * @return
     */
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return code + ":" + msg;
    }

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取枚举
     *
     * @param code
     * @return
     */
    public static ResultCode getByCode(int code) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.code == code) {
                return resultCode;
            }
        }
        return UNKOWN;
    }

}
