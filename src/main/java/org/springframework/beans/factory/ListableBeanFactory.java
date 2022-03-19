package org.springframework.beans.factory;

import java.util.Map;

/**
 * 1 * @Author: deng.tengfei
 * 2 * @email: imdtf@qq.com
 * 3 * @Date: 2022/3/19 18:07
 * 4
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 返回指定类型的所有实例
     * @param type 类型
     * @param <T> 反向
     * @return 结果
     */
    <T> Map<String, T> getBeansOfType(Class<T> type);

    /**
     * 返回所有定义的 bean 名称
     * @return 结果
     */
    String[] getBeanDefinitionNames();
}
