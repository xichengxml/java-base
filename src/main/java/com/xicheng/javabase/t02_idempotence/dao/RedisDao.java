package com.xicheng.javabase.t02_idempotence.dao;

import com.xicheng.javabase.t02_idempotence.common.RedisConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-05-16 20:39
 */
@Repository
@Slf4j
public class RedisDao {

    private Jedis jedis;

    private void createClient() {
        jedis = new Jedis(RedisConstant.HOST, RedisConstant.PORT);
    }

    public void set(final String key, String value) {
        createClient();
        jedis.set(key, value);
        jedis.close();
    }

    public String get(final String key) {
        createClient();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    public void setEx(final String key, String value, int expireTime) {
        createClient();
        jedis.setex(key, expireTime, value);
        jedis.close();
    }

    public void delete(final String key) {
        createClient();
        jedis.del(key);
        jedis.close();
    }
}
