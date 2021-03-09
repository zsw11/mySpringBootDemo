package com.zsw.enumModel;

/**
 * @author zsw
 * @date 2021/3/8 14:05
 * @description : 状态枚举，定义返回结果集的状态
 */
public enum Status {

    FAIL(500,"失败"),
    SUCCESS(200,"成功"),
    EXCEPTION(101,"未知异常")
    ;

    private int code;
    private String status;

    Status(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return status;
    }

    public void setMessage(String status) {
        this.status = status;
    }
}
