package com.zl.springbootredis.controller;

import com.zl.springbootredis.entity.User;
import com.zl.springbootredis.util.RedisUtil;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @description:
 * @author: zl
 * @date: 2019-02-18 15:09
 */
@RestController
public class TestController {
    /**
     * redis：http://www.runoob.com/redis/redis-strings.html
     * redis的优势，读写速度快
     * redis 五种数据类型字符串对象、
     * redis键对应的操作：
     * del key 删除key
     * dump key 序列化key
     * exists key 判断key是否存在
     * expire key seconds 设置过期时间
     * rename key newkey 修改key的名称
     * type key 返回key的值类型
     *
     * 字符串对象对应的操作：set k1 1 ,object encoding k1 ，三种编码方式int编码（保存整数值）,embstr编码保存长度小于44字节的字符串,raw编码保存长度大于44字节的字符串
     * get key 获取指定key的值
     * mget k1 k2 获取多个key指定的值，返回值为列表
     * mset k1 value1 k2 value2 返回值为ok
     * msetnx k1 value1 k2 value2 所有key都不存在时，设置
     * setnx key value 只在在key不存在时设置key的值
     * strlen key 返回字符串值的长度
     * getrange key start end 返回值的子字符串
     * incr k1 将k1中存储的数据值加1
     * decr k1 将k1中存储的数据值减1
     * append key value 在key后面添加value
     *
     * 列表对象对应的操作：（应用场景，简单实现消息队列），两种编码方式ziplist（压缩列表）和linkedlist（双端链表），ziplist存储的元素个数小于512个，长度小于64字节
     * lpush key1 value1 key2 value2 将一个或多个key插入到列表头部
     * lpop key 移除列表头部第一个元素
     * blpop key timeout 移出并获取列表第一个元素
     * lindex key index 通过索引获取列表中的元素
     * llen key 获取列表长度
     * linsert key before|after pivot(插入点) value 在列表元素钱或者后插入元素
     *
     * 哈希对象对应的操作：（应用场景，单点登陆存放用户信息），两种编码方式ziplist和hashtable
     * hmset key field1 value1 field2 value2 将多个field-value域设置到哈希表
     * hset key field value 将field的值设为value
     * hdel key field 删除一个或多个哈希表字段
     * hexists key field 查看字段是否存在
     * hget key field 获取字段的值
     * hgetall key 获取所有字段和值
     * hkeys key 获取所有字段
     * hmget key field1 field2 获取所有给定字段的值
     *
     * 集合对象对应的操作：（应用场景，底层是字典实现，查找速度快，set数据不允许重复，可以用于判断用户名是否注册），两种编码方式intset和hashtable，intset存储整数集合，元素数量不超过512，hashtable使用字典作为底层实现
     * sadd key men1 men2 向集合中添加一个或多个成员
     * scard key 获取集合的成员数
     * sdiff key1 key2 返回所有集合的差集
     * sinter key1 key2 返回交集
     * sismenber key men 判断mem元素是否是集合key的成员
     * srem key men1 men2移出集合中的一个或多个成员
     * sunion key1 key2 返回并集
     *
     * 有序集合对象的操作：（应用场景，有序集合，可以做范围查找，排行榜），两种编码方式： ziplist和skiplist，ziplist保存元素数量小于128，所有元素长度小于64字节。
     * zadd key score1 men1 score2 men2 向集合中添加一个或多个成员
     * zrange key start stop 返回区间内的成员
     * zrank key mem 返回指定位置的成员
     * zrem key mem 移出一个或多个成员
     *
     * redis事物管理：multi开启一个事物，exec触发执行
     *
     * redis发布订阅：
     * publish channel message 将信息发送到指定的频道
     * subscribe channel 订阅一个或多个频道
     * unsubscribe channel 退出指定的频道
     *
     */
    @Resource
    RedisTemplate redisTemplate;

    /**
     * redisUtil redis操作工具
     */
    @Resource
    RedisUtil redisUtil;

    @RequestMapping("/setStringObject")
    public String setStringObject(){

        User user = new User();
        user.setUsername("zm");
        user.setPassword("xx");
        /*set，插入key-value为 String-Objecte类型的数据
        redisUtil.set("user",user);
        redisUtil.expire("user",1);
        */
        /*set，插入key-value，同时设置缓存时间
                redisUtil.set("user",user,1);
         */
        //redisUtil.set("user",user);
        redisUtil.set("title","english");
        //redisTemplate.opsForValue().append("title","user");
        //delete,删除key
        //redisUtil.del("user");
        //指定缓存失效时间，单位是s
        //get，通过key获得value值
        System.out.println((String)(redisTemplate.opsForValue().get("ti")));
        return "ok";
    }

}
