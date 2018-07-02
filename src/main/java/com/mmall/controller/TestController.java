package com.mmall.controller;

import com.mmall.exception.ParamException;
import com.mmall.common.JsonData;
import com.mmall.param.TestVo;
import com.mmall.util.BeanValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by easom on 2017/12/2.
 */
@RequestMapping("/test")
@Slf4j
@Controller
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello(){
        log.info("hello");
        //return JsonData.success("hellohello");
        //throw new  PermissionException("test exception");
        throw new RuntimeException("test exception");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) throws ParamException{
        log.info("validate");
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
}
