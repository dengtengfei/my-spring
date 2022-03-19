package org.springframework.test.ioc;

import cn.hutool.core.io.IoUtil;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * 1 * @Author: deng.tengfei
 * 2 * @email: imdtf@qq.com
 * 3 * @Date: 2022/3/19 16:11
 * 4
 */
public class ResourceAndResourceLoaderTest {
    @Test
    public void testResourceLoader() throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        Assertions.assertThat(content).isEqualTo("hello spring\r\n");

        resource = resourceLoader.getResource("src/test/resources/hello.txt");
        Assertions.assertThat(resource instanceof FileSystemResource).isTrue();
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        Assertions.assertThat(content).isEqualTo("hello spring\r\n");

        resource = resourceLoader.getResource("https://gitee.com/imdtf");
        Assertions.assertThat(resource instanceof UrlResource).isTrue();
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        Assertions.assertThat(content).isNotBlank();
    }
}
