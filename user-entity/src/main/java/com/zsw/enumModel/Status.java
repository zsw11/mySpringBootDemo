package com.zsw.enumModel;

/**
 * @author zsw
 * @date 2021/3/8 14:05
 * @description :
 */
public enum Status {

    FAIL(500,"失败"),
    SUCCESS(200,"成功");

    private int code;
    private String message;

    Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
