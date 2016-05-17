package com.bhavin.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by bhavinchauhan on 5/18/16.
 */
@Service
public class CachingService<K> {
    private static final String REDIS_HOST = "127.0.0.1";
    private static final Integer REDIS_PORT = 6379;
    RedisClient redisClient = new RedisClient(REDIS_HOST, REDIS_PORT, 0);

    public CachingService(RedisClient redisClient) {
        this.redisClient = redisClient;
    }

    public CachingService() {
    }

    public void set(String key, K obj, long expiry) throws JsonProcessingException {
        String res = CSVToEntity.jsonEncode(obj);
        redisClient.set(key, res, expiry);
        return;
    }

    public void delete(String key) {
        redisClient.del(key);
    }

    public <T> T get(String key, TypeReference<T> ref) throws IOException {
        String value =  redisClient.get(key);
        if( value == null)
            return null;
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.readValue(value, ref);
    }

}
