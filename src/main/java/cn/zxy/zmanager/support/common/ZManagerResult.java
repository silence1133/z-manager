package cn.zxy.zmanager.support.common;

import lombok.Data;


@Data
public class ZManagerResult<T> extends BaseResult {

    private T data;

    private int totalPages;

    public ZManagerResult() {
        super(true, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg());
    }

    public ZManagerResult(T data, boolean success, int code, String msg, int totalPages) {
        super(success, code, msg);
        this.data = data;
        this.totalPages = totalPages;
    }

    public static ZManagerResult success() {
        return newBuilder().success(true).data(null).code(ResultCode.SUCCESS.getCode()).msg(ResultCode.SUCCESS.getMsg()).build();
    }

    public static <T> ZManagerResult success(T data) {
        return newBuilder().success(true).data(data).code(ResultCode.SUCCESS.getCode()).msg(ResultCode.SUCCESS.getMsg()).build();
    }

    public static <T> ZManagerResult success(T data, int totalPages) {
        return newBuilder().success(true).data(data).code(ResultCode.SUCCESS.getCode()).msg(ResultCode.SUCCESS.getMsg())
                .totalPages(totalPages)
                .build();
    }

    public static ZManagerResult fail(int code, String msg) {
        return newBuilder().success(false).data(null).code(code).msg(msg).build();
    }

    public static <T> ZManagerResult fail(T data, int code, String msg) {
        return newBuilder().success(false).data(data).code(code).msg(msg).build();
    }

    public static ZManagerResult fail(ResultCode errorCode) {
        return newBuilder().success(false).data(null).code(errorCode.getCode()).msg(errorCode.getMsg()).build();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder<T> extends BaseResult.Builder {

        private T data;

        private int totalPages;

        protected Builder getThis() {
            return this;
        }

        public ZManagerResult build() {
            return new ZManagerResult(data, success, code, msg, totalPages);
        }

        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public Builder code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder totalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public Builder success(Boolean success) {
            this.success = success;
            return this;
        }
    }

    @Override
    public String toString() {
        return "ZManagerResult{" +
                "data=" + data +
                ", totalPages=" + totalPages +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }

}
