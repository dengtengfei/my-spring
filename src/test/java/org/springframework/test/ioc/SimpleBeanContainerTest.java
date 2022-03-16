package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 1 * @Author: deng.tengfei
 * 2 * @email: imdtf@qq.com
 * 3 * @Date: 2022/3/16 22:54
 * 4
 */
public class SimpleBeanContainerTest {
    @Test
    public void testGetBean() {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("helloService", new HelloService());
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        assertThat(helloService).isNotNull();
        assertThat(helloService.sayHello()).isEqualTo("hello");
    }

    private static class HelloService {
        public String sayHello() {
            System.out.println("hello");
            return "hello";
        }
    }
}
