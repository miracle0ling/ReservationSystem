package Impl;

import mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

@Service
@Transactional
public class RedisImpl extends ActivityServiceImpl {

    @Autowired
    private OrderItemMapper orderItemMapper;

    public void setinRedis(){
        //1、获得连接对象
        Jedis jedis = new Jedis("192.168.186.131", 6379);


        //2、获得数据
        String username = jedis.get("username");
        System.out.println(username);

        //3、存储
        jedis.set("addr", "北京");
        System.out.println(jedis.get("addr"));
    }
}
