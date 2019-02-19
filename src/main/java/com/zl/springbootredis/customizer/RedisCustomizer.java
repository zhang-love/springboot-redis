package com.zl.springbootredis.customizer;

import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;

/**
 * @description:
 * @author: zl
 * @date: 2019-02-18 17:17
 */
public class RedisCustomizer implements LettuceClientConfigurationBuilderCustomizer {
    @Override
    public void customize(LettuceClientConfiguration.LettuceClientConfigurationBuilder clientConfigurationBuilder) {

    }
}
