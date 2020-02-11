package com.wenyanwen123.learning.controller;

import com.wenyanwen123.learning.commons.response.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO
 * @Author liww
 * @Date 2020/2/11
 * @Version 1.0
 */
@Api(value = "模板引擎")
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @ApiOperation(value = "测试")
    @ApiResponse(code = 200, message = "ok", response = String.class)
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("msg", "你当像鸟飞往你的山");
        return "hello";
    }

}
