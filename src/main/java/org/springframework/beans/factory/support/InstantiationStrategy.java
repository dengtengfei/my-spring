package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * Bean 的实例化策略
 * 1 * @Author: deng.tengfei
 * 2 * @email: imdtf@qq.com
 * 3 * @Date: 2022/3/19 14:15
 * 4
 */
public interface InstantiationStrategy {

    /** 实例化
     * @param beanDefinition bean 定义对象
     * @return 对象
     */
    Object instantiate(BeanDefinition beanDefinition);
}
