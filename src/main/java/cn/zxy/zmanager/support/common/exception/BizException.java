package cn.zxy.zmanager.support.common.exception;


import cn.zxy.zmanager.support.common.ResultCode;

public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1987120495063545921L;

    private int errorCode;
    private String errorMsg;

    public BizException(String msg) {
        super(msg);
        errorMsg = msg;
    }

    public BizException(Throwable cause) {
        super(cause);
        errorMsg = cause.getMessage();
    }

    public BizException(String msg, Throwable cause) {
        super(msg, cause);
        errorMsg = msg;
    }

    public BizException(int errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.errorCode = resultCode.getCode();
        this.errorMsg = resultCode.getMsg();
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public String toString() {
        return "BizException [errorCode=" + errorCode + ",errorMsg=" + errorMsg + "]";
    }
}
