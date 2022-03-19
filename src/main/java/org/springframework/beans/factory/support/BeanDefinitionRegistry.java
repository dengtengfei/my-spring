package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * 1 * @Author: deng.tengfei
 * 2 * @email: imdtf@qq.com
 * 3 * @Date: 2022/3/16 23:26
 * 4
 */
public interface BeanDefinitionRegistry {
    /**
     * 想注册表中注册 BeanDefinition
     *
     * @param beanName       名称
     * @param beanDefinition 定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
