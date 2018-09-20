package cn.zxy.zmanager.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述你的类
 * @author Silence 000996
 * @data 18/9/17
 */
@Data
abstract class BaseResult implements Serializable {

    private static final long serialVersionUID = -7304713318859825120L;

    protected int code = ResultCode.SUCCESS.getCode();

    protected String msg = "";

    protected boolean success = true;

    protected BaseResult(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    public abstract static class Builder<R extends BaseResult, B extends Builder<R, B>> {

        private B theBuilder;

        protected Boolean success;
        protected Integer code;
        protected String msg;

        public Builder() {
            theBuilder = getThis();
        }

        protected abstract B getThis();

        public B code(Integer code) {
            this.code = code;
            return theBuilder;
        }

        public B msg(String msg) {
            this.msg = msg;
            return theBuilder;
        }

        public B success(Boolean success) {
            this.success = success;
            return theBuilder;
        }

        public abstract R build();

    }


    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }
}