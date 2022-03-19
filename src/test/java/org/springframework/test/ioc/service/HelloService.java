package org.springframework.test.ioc.service;

/**
 * 1 * @Author: deng.tengfei
 * 2 * @email: imdtf@qq.com
 * 3 * @Date: 2022/3/16 23:10
 * 4
 */
public class HelloService {
    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }
}
