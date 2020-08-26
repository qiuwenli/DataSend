package com.lgom.transport.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr qiu
 * @description 全局异常处理
 * @date 2020-06-19 17:02
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**给controller添加异常处理，括号中指定要捕获处理哪种异常，Exception.class表示处理所有种类的异常
     * 全局异常
     * @param e
     */
    @ExceptionHandler(Exception.class)
    public void handler1(Exception e){ //如果要使用异常对象，可以作为参数传入异常对象
        Map<String, String> map = new HashMap<>(2);
        System.out.println(e.getMessage().toString()+"----");
    }

}
