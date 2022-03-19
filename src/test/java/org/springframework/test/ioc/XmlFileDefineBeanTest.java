package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.test.ioc.bean.Car;
import org.springframework.test.ioc.bean.Person;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1 * @Author: deng.tengfei
 * 2 * @email: imdtf@qq.com
 * 3 * @Date: 2022/3/19 18:57
 * 4
 */
public class XmlFileDefineBeanTest {
    @Test
    public void testXmlDefineBean() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        Person person = (Person) beanFactory.getBean("person");
        assertThat(person).isNotNull();
        System.out.println(person);
        assertThat(person.getName()).isEqualTo("imdtf");
        assertThat(person.getAge()).isEqualTo(18);
        assertThat(person.getCar()).isNotNull();
        assertThat(person.getCar().getBrand()).isEqualTo("porsche");

        Car car = (Car) beanFactory.getBean("car");
        assertThat(car).isNotNull();
        System.out.println(car);
        assertThat(car.getBrand()).isEqualTo("porsche");
    }
}
