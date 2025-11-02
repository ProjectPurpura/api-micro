package org.purpura.apimicro.service;

import org.purpura.apimicro.model.ValidCepWrapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveValidCep(String key, ValidCepWrapper validCepWrapper, long ttl, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, validCepWrapper, ttl, timeUnit);
    }

    public ValidCepWrapper getValidCep(String key) {
        Object value = redisTemplate.opsForValue().get(key);
        if (value instanceof ValidCepWrapper) {
            return (ValidCepWrapper) value;
        }
        return null;
    }
}
