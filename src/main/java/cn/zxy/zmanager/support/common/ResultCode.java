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
    
    EXCEL_DATA_ERROR(100300001, "excel 数据数据"),
    
    OUT_STOCK_NUM_BIG_THAN_STOCK(1004000001, "出库数量超过库存，清刷新当前页面"),

    /*未知错误*/
    UNKOWN(-1, ""), 
    
    BAN_MODIFY_HOUSE_STATUS(1005000001, "门面已出租，禁止修改状态，修改失败"), 
    
    BAN_MODIFY_CONTRACT_STATUS(1006000001, "合同已为无效或终止状态，不能再对其进行修改，修改失败"), 
    
    BAN_MODIFY_MERCHANT_STATUS(1007000001, "该商户存在有效合同，不能修改状态，修改失败");


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
