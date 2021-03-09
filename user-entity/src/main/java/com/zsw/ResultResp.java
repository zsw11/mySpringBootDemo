package com.zsw;

import com.zsw.enumModel.Status;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zsw
 * @date 2021/3/8 17:28
 * @description : 定义的返回结果集对象，每一种返回结果集，就在这里定义一下。
 */
@Data
public class ResultResp<T> {
    @ApiModelProperty("状态码 500失败 200成功 等等")
    private Integer code;

    @ApiModelProperty("返回信息")
    private String msg;

    @ApiModelProperty("返回数据")
    private T data;

    public ResultResp(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResultResp success(T data){
        return new ResultResp<>(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), data);
    }

    public static <T>  ResultResp fail(T data){
        return new ResultResp<>(Status.FAIL.getCode(), Status.FAIL.getMessage(), data);
    }

    public static <T>  ResultResp exception(T data){
        return new ResultResp<>(Status.EXCEPTION.getCode(), Status.EXCEPTION.getMessage(), data);
    }


}
