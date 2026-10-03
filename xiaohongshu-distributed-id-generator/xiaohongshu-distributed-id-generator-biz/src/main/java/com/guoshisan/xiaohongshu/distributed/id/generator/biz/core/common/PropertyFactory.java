package com.guoshisan.xiaohongshu.distributed.id.generator.biz.core.common;

import com.guoshisan.xiaohongshu.distributed.id.generator.biz.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class PropertyFactory {
    private static final Logger logger = LoggerFactory.getLogger(PropertyFactory.class);
    private static final Properties prop = new Properties();
    static {
        try {
            prop.load(PropertyFactory.class.getClassLoader().getResourceAsStream("leaf.properties"));
            String password = System.getenv("DB_PASSWORD");
            if (password == null || password.isBlank()) {
                throw new IllegalStateException("DB_PASSWORD is not set");
            }

            prop.setProperty(Constants.LEAF_JDBC_PASSWORD, password);
        } catch (IOException e) {
            logger.warn("Load Properties Ex", e);
        }
    }
    public static Properties getProperties() {
        return prop;
    }
}
