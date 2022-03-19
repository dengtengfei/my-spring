package org.springframework.core.io;

/**
 * 1 * @Author: deng.tengfei
 * 2 * @email: imdtf@qq.com
 * 3 * @Date: 2022/3/19 16:04
 * 4
 */
public interface ResourceLoader {

    /**
     * 获取资源
     *
     * @param location 路径
     * @return 资源
     */
    Resource getResource(String location);
}
