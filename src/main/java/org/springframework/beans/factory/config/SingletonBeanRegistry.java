package org.springframework.beans.factory.config;

/**
 * 1 * @Author: deng.tengfei
 * 2 * @email: imdtf@qq.com
 * 3 * @Date: 2022/3/16 23:12
 * 4
 */
public interface SingletonBeanRegistry {
    /**
     * 获取单例
     *
     * @param beanName bean 名称
     * @return 对象
     */
    Object getSingleton(String beanName);
}
