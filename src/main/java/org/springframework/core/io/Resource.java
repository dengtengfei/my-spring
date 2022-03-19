package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 1 * @Author: deng.tengfei
 * 2 * @email: imdtf@qq.com
 * 3 * @Date: 2022/3/19 15:59
 * 4
 */
public interface Resource {

    /**
     * 获取输入流
     *
     * @return 输入流
     * @throws IOException io 异常
     */
    InputStream getInputStream() throws IOException;
}
