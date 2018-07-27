package com.neusoft.tools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnection {
	
	public static Jedis getJedis(){
		JedisPoolConfig config = new JedisPoolConfig();//set方法
		JedisPool jedisPool = new JedisPool(config,"10.25.39.199",6379,6000,"175516");//构造方法传值
		return jedisPool.getResource();
	}
	
}
