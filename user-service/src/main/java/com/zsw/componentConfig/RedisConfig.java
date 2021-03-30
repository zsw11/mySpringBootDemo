package com.zsw.componentConfig;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 描述：redis配置类
 *
 *      redis序列化方式选择：
 *          1、(默认的)JdkSerializationRedisSerializer序列化方式，其编码为 ISO-8859-1，会出现乱码问题；
 *          2、StringRedisSerializer序列化方式，其编码为 UTF-8，可以解决乱码问题；
 *
 * @author yys
 * @date 2019.04.30
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    // springboot 1.x 配置
    @Bean
    public CacheManager CacheManagercacheManager(RedisTemplate<?, ?> redisTemplate) {
        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(factory);

        /**
         * 在这里，改用StringRedisSerializer序列化方式
         *      a、setKeySerializer：对redis的key值 设置序列化方式
         *      b、setValueSerializer：对redis的value值 设置序列化方式
         *                            (若配置则只能接受String类型，其他类型需转为String类型)
         */
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        redisTemplate.setKeySerializer(stringRedisSerializer); // a
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(stringRedisSerializer); // b
        redisTemplate.setHashValueSerializer(stringRedisSerializer);

        return redisTemplate;
    }

}