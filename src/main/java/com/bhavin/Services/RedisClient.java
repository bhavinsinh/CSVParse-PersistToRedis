package com.bhavin.Services;

import lombok.Setter;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * Created by bhavinchauhan on 5/18/16.
 */
@Setter
public class RedisClient {

    private Jedis jedis;


    public RedisClient(String url, int port, int dbIndex) {
        this.jedis = new Jedis(url, port);
        this.jedis.select(dbIndex);
    }

    public String get(String key) {
        return this.jedis.get(key);
    }

    public void set(String key, String value) {
        this.jedis.set(key, value);
    }

    public void set(String key, String value, long expiry) {
        this.jedis.set(key, value);
    }

    public Set<String> keys(String pattern) {
        return this.jedis.keys(pattern);
    }

    public void expire(String key, int seconds) {
        this.jedis.expire(key, seconds);
    }

    public void del(String key) {
        this.jedis.del(key);
    }

    public List<String> mget(String[] keys) {
        return this.jedis.mget(keys);
    }

    public Long sadd(String set_name, String... value) {
        return this.jedis.sadd(set_name, value);
    }

    public Long sremove(String set_name, String... value) {
        return this.jedis.srem(set_name, value);
    }
    public void  close() { this.jedis.close();}

}
