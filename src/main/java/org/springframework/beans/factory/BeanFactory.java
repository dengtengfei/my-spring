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
}
