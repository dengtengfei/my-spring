package org.springframework.beans.factory;

/**
 * 1 * @Author: deng.tengfei
 * 2 * @email: imdtf@qq.com
 * 3 * @Date: 2022/3/16 22:52
 * 4
 */
public interface BeanFactory {

    /**
     * 获取 bean
     *
     * @param name bean名称
     * @return 对象
     */
    Object getBean(String name);

    /**
     * 根据名称和类型查找 bean
     * @param name 名称
     * @param requiredType 类型
     * @param <T> 泛型
     * @return 结果
     */
    <T> T getBean(String name, Class<T> requiredType);
}
