/*package com.yabushan.test.util.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisClient {
	

	private Jedis jedis;// 非切片额客户端连接
	private JedisPool jedisPool;// 非切片连接池
	private ShardedJedis shardedJedis;// 切片额客户端连接
	private ShardedJedisPool shardedJedisPool=null;// 切片连接池
	private int MaxTotal = 300;
	private int maxIdle = 100;
	private long maxWait = 3000;
	private final int ONE_MONTH=2592000;
	private final int ONE_WEEK=7*24*60*60*1000;
	
	private static RedisClient redisClient;

	public static RedisClient getInstance() {
		if (redisClient == null) {
			redisClient = new RedisClient();
		}
		return redisClient;
	}

	public RedisClient() {
		initialPool();
		initialShardedPool();
		shardedJedis = shardedJedisPool.getResource();
		jedis = jedisPool.getResource();

	}

	*//**
	 * 初始化非切片池
	 *//*
	private void initialPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		// config.setMaxActive(20);
		// config.setMaxIdle(5);
		// config.setMaxWait(1000l);
		// 设置最大连接数
		config.setMaxTotal(MaxTotal);
		// 设置最大空闲数
		config.setMaxIdle(maxIdle);
		// 设置超时时间
		config.setMaxWaitMillis(maxWait);
		config.setTestOnBorrow(false);

		jedisPool = new JedisPool(config, "127.0.0.1", 6379);
	}

	*//**
	 * 初始化切片池
	 *//*
	private void initialShardedPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		// 设置最大连接数
		config.setMaxTotal(MaxTotal);
		// 设置最大空闲数
		config.setMaxIdle(maxIdle);
		// 设置超时时间
		config.setMaxWaitMillis(maxWait);
		config.setTestOnBorrow(false);
		// slave链接
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		shards.add(new JedisShardInfo("127.0.0.1", 6379));

		// 构造池
		shardedJedisPool = new ShardedJedisPool(config, shards);
	}
	
	  public ShardedJedis getJedis(){
	        return this.shardedJedisPool.getResource();
	    }
	    
	    public void returnBrokenResource(ShardedJedis jedis){
	    	this.shardedJedisPool.returnBrokenResource(jedis);
	    }
	    
	    public void returnJedis(ShardedJedis jedis){
	        this.shardedJedisPool.returnResource(jedis);
	    }

	
	
	
	
	
	public void cloes() {
		jedisPool.returnResource(jedis);
		shardedJedisPool.returnResource(shardedJedis);
		//System.out.println("show");
	}

	public void setString(String phoneNum, String code) {
		jedis.set(phoneNum, code);
		jedis.expire(phoneNum, 600);

	}
	
	public  void setToken(String userId,String refleshtoken){
		Map<String, String> tokenMap=new HashMap<String, String>();
		tokenMap.put("retoken", refleshtoken);
		tokenMap.put("retime", String.valueOf(System.currentTimeMillis()));
		jedis.hmset(userId, tokenMap);
		jedis.expire(refleshtoken,ONE_WEEK);
		
	}
	
	//检查验证码是否过期
	public boolean outDate(String phoneNum){
		return jedis.exists(phoneNum);
	}

	public boolean isExist(String phoneNum, String code) {
		if (jedis.exists(phoneNum) && jedis.get(phoneNum).equals(code)) {
			jedis.del(phoneNum);
			
			return true;
		}
		return false;
	}
	
	
	public boolean setHashMap(String key,Map<String , String> map){
		
		try {
			
			jedis.hmset(key, map);
			jedis.expire(key, ONE_MONTH);
			return true;
		} catch (Exception e) {
			
			return false;
		}
	
	}
	
	public Map<String, String> hget(String key){
		
		Map<String, String> map=new HashMap<String, String>();
		try {
		map=jedis.hgetAll(key);
		} catch (Exception e) {
			map=null;
		}
		
		return map;
	}
	
	public boolean Hset(String key,String field,String value){
		
		boolean result=false;
		try {
			jedis.hset(key, field, value);
			
			result= true;
			
		} catch (Exception e) {
			
			
		}
		
		return result;
	}
	
	
	
	
	public List<Map<String, String>> gethashMaplist(Map<String, String> map){
		List<String> keyList=new ArrayList<String>();
		for(String key:map.keySet()){
			keyList.add(key);
		}
		List<Map<String, String>> maps=new ArrayList<Map<String,String>>();
		for(String keyString:keyList){
			Map<String, String> mpaMap=new HashMap<String, String>();
		mpaMap=	jedis.hgetAll(keyString);
		maps.add(mpaMap);
		}
		
		return maps;
	}
	
	
	public boolean deleteSuccssCheackShop(String key,String filed){
		boolean result=true;
		try {
			jedis.del(filed);//此处的filed为shopId
			jedis.hdel(key, filed);
			
		} catch (Exception e) {
			
			result=false;
		}
		
		return result;
	}
	
}
*/