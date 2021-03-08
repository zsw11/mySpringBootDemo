package com.zsw.controller;

import com.zsw.ResultResp;
import com.zsw.enumModel.Status;
import com.zsw.model.User;
import com.zsw.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zsw
 * @date 2021/3/8 11:41
 * @description : user
 */
@RestController("/user")
@Api("用户信息")
public class IUserController {

    @Resource
    private IUserService iUserService;

    @ApiOperation(value = "添加用户")
    @PostMapping("/add")
    public ResultResp addUser(@Validated User user, BindingResult bingingResult) { //@Validated 表示检验User 对象， BindingResult 表示检验出错是保存的错误信息
        ArrayList<String> result = new ArrayList<>();
        if(bingingResult.hasErrors()){
            List<ObjectError> allErrors = bingingResult.getAllErrors();
            for(ObjectError error: allErrors ){
                result.add(error.getDefaultMessage());
            }
            return ResultResp.fail(result);
        }
        Status status = null;
//        try catch 可以提高程序的健壮性,比如，数据库设置phone不能为空，但是没有传值，并且代码也没有检验，这时数据库就会报错，
//        但是前段人员看不懂，我们就可以，捕获异常，并返回特定的code和msg，前段就更好的做处理，当然最好是之前就判断phone不为空，
//        但是测序的异常有的时候我们并不值得，所以就是用trycatch
        try{
             status = iUserService.addUser(user);
        }catch (Exception e){
            return ResultResp.fail("phone不能为空");
        }
//        Status status = iUserService.addUser(user);
        return ResultResp.success(status);
    }
}
