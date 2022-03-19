package org.springframework.beans.factory.support;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * 1 * @Author: deng.tengfei
 * 2 * @email: imdtf@qq.com
 * 3 * @Date: 2022/3/19 16:27
 * 4
 */
public interface BeanDefinitionReader {

    /**
     * 获取 bean 注册器
     *
     * @return bean 注册器
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     *
     * @return 资源加载器
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载 bean 定义
     *
     * @param resource 资源
     */
    void loadBeanDefinitions(Resource resource);

    /**
     * 加载 bean 定义
     *
     * @param location 资源路径
     */
    void loadBeanDefinitions(String location);

    /**
     * 加载 bean 定义
     *
     * @param locations 资源路径
     */
    void loadBeanDefinitions(String[] locations);
}
