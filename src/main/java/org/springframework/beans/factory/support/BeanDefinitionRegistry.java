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

    /**
     * 根据名称查找
     *
     * @param beanName 名称
     * @return bean 定义
     */
    BeanDefinition getBeanDefinition(String beanName);

    /**
     * 是否包含指定名称的 BeanDefinition
     * @param beanName 名称
     * @return 结果
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回所有定义的 bean 名称
     * @return 结果
     */
    String[] getBeanDefinitionNames();
}
