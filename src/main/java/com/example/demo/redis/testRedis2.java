package com.example.demo.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import redis.clients.jedis.Jedis;


public class testRedis2 {
	
	//对key的测试
	public static void keyTest() {
		 Jedis jedis = new Jedis("localhost");
		
		 //清空数据
	    System.out.println(jedis.flushDB());
	    //打印hello
	    System.out.println(jedis.echo("hello"));
	    //判断key是否存在
	    System.out.println(jedis.exists("foo"));
	    jedis.set("key1", "values1");
	    jedis.set("key2", "values2");
	    //判断key是否存在
	    System.out.println(jedis.exists("key1"));
	    //选择一个随机的key
	    String randomKey = jedis.randomKey();
	    System.out.println("randomKey的为: " + randomKey);
	    //生存时间
	    jedis.expire("key1", 60);
	    //剩下的生存时间
	    System.out.println(jedis.pttl("key1"));
	    //移除key的过期时间
	    jedis.persist("key1");
	    // 获取key的类型, "string", "list", "set" "none" none表示key不存在
	    System.out.println("type的类型为: " + jedis.type("key1"));
	    //key的类型
	    // 导出key的值
	    String value = jedis.get("key1");
	    System.out.println(value);
	    // 将key重命名
	    jedis.renamenx("key1", "keytest");
	    System.out.println("key1是否存在: " + jedis.exists("key1"));
	    // 判断是否存在
	    System.out.println("keytest是否存在: " + jedis.exists("keytest"));
	    // 判断是否存在
	    // 查询匹配的key
	    // KEYS * 匹配数据库中所有 key 。
	    // KEYS h?llo 匹配 hello ， hallo 和 hxllo 等。
	    // KEYS h*llo 匹配 hllo 和 heeeeello 等。
	    // KEYS h[ae]llo 匹配 hello 和 hallo ，但不匹配 hillo 。
	    // 特殊符号用 \ 隔开。
	    Set<String> set = jedis.keys("k*");
	    //获取所有相关的key keys方法
	    System.out.println(set);
	    jedis.del("key1");
	    // 删除key del方法
	    System.out.println(jedis.exists("key1"));
	}
	
	
	public static void stringTest() {
		Jedis jedis = new Jedis("localhost");
		
		//set
	    jedis.set("hello", "hello");
	    //get
	    System.out.println(jedis.get("hello"));
	    // 使用append 向字符串后面添加
	    jedis.append("hello", " world");
	    //追加 append方法
	    System.out.println(jedis.get("hello"));
	    // set覆盖字符串
	    jedis.set("hello", "123");
	    System.out.println(jedis.get("hello"));
	    // 设置过期时间
	    jedis.setex("hello2", 2, "world2");
	    System.out.println(jedis.get("hello2"));
	    try {
	        Thread.sleep(3000);
	    }
	    catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    System.out.println(jedis.get("hello2"));
	    
	    
	    // 一次添加多个key-value对
	    jedis.mset("a", "1", "b", "2");
	    // 获取a和b的value
	    List<String> valus = jedis.mget("a", "b");
	    System.out.println(valus);
	    // 批量删除
	    jedis.del("a", "b");
	    System.out.println(jedis.exists("a"));
	    System.out.println(jedis.exists("b"));
	}
	
	
	public static  void listTest() {
		
		Jedis jedis = new Jedis("localhost");
		 // 清空数据
	    System.out.println(jedis.flushDB());
	    
	    
	    String key = "mylist";
	    //把之前的删除
	    jedis.del(key);
	 
	    // 队列添加元素
	    jedis.rpush(key, "aaaa");
	    jedis.rpush(key, "aaaa");
	    jedis.rpush(key, "bbbb");
	    jedis.rpush(key, "cccc");
	    jedis.rpush(key, "cccc");
	    //队列长度
	    System.out.println("lenth: " + jedis.llen(key));
	    // 打印队列，从索引0开始，到倒数第1个（全部元素）
	    System.out.println("all elements: " + jedis.lrange(key, 0, -1));
	    // 索引为1的元素
	    System.out.println("index of 1: " + jedis.lindex(key, 1));
	    // 改队列里的值 设置队列里面一个元素的值，当index超出范围时会返回一个error。
	    jedis.lset(key, 1, "aa22");
	    System.out.println("index of 1: " + jedis.lindex(key, 1));
	    // 从队列的右边入队一个元素
	    jedis.rpush(key, "-2", "-1");
	    // 先-2，后-1入队列
	    System.out.println("all elements: " + jedis.lrange(key, 0, -1));
	    // 从队列的左边入队一个或多个元素
	    jedis.lpush(key, "second element", "first element");
	    // 先second
	    // element，后first
	    // elementF入队列
	    System.out.println("all elements: " + jedis.lrange(key, 0, -1));
	    // 从队列的右边出队一个元素
	    System.out.println(jedis.rpop(key)+"!!!!!!!!!");
	    // 从队列的左边出队一个元素
	    System.out.println(jedis.lpop(key)+"!!!!!!!!!");
	    System.out.println("all elements: " + jedis.lrange(key, 0, -1));
	    //Redis Lrem 根据参数 COUNT 的值，移除列表中与参数 VALUE 相等的元素。
	    // count > 0: 从头往尾移除值为 value 的元素，count为移除的个数。
	    // count < 0: 从尾往头移除值为 value 的元素，count为移除的个数。
	    // count = 0: 移除所有值为 value 的元素。
	    jedis.lrem(key, 1, "cccc");
	    System.out.println("all elements: " + jedis.lrange(key, 0, -1));
	    // 即最右边的那个元素也会被包含在内。 如果start比list的尾部下标大的时候，会返回一个空列表。
	    // 如果stop比list的实际尾部大的时候，Redis会当它是最后一个元素的下标。
	    System.out.println(jedis.lrange(key, 0, 2));
	    System.out.println("all elements: " + jedis.lrange(key, 0, -1));
	    // 删除区间以外的元素
	    System.out.println(jedis.ltrim(key, 0, 2));
	    System.out.println("all elements: " + jedis.lrange(key, 0, -1));
	}
	
	
	public static void setTest() {
		Jedis jedis = new Jedis("localhost");
		
	    // 清空数据
	    System.out.println(jedis.flushDB());
	    String key = "myset1";
	    String key2 = "myset2";
	    // 集合添加元素
	    jedis.sadd(key, "aaa", "bbb", "ccc");
	    jedis.sadd(key2, "bbb", "ccc", "ddd");
	    // 获取集合里面的元素数量
	    System.out.println(jedis.scard(key));
	    //the number count of the set
	    // 获得两个集合的交集，并存储在一个关键的结果集
	    jedis.sinterstore("destination", key, key2);
	    System.out.println(jedis.smembers("destination"));
	    // 获得两个集合的并集，并存储在一个关键的结果集
	    jedis.sunionstore("destination", key, key2);
	    System.out.println(jedis.smembers("destination"));
	    // key1集合中，key2集合没有的元素，并存储在一个关键的结果集
	    jedis.sdiffstore("destination", key, key2);
	    System.out.println(jedis.smembers("destination"));
	    // 确定某个元素是一个集合的成员
	    System.out.println(jedis.sismember(key, "aaa"));
	    // 从key集合里面随机获取一个元素
	    System.out.println(jedis.srandmember(key));
	    // aaa从key移动到key2集合
	    jedis.smove(key, key2, "aaa");
	    System.out.println(jedis.smembers(key));
	    //获取集合中的元素
	    System.out.println(jedis.smembers(key2));
	    // 删除并获取一个集合里面的元素
	    System.out.println(jedis.spop(key));
	    // 从集合里删除一个或多个元素
	    jedis.srem(key2, "ccc", "ddd");
	    System.out.println(jedis.smembers(key2));
	}
	
	
	public static void zsetTest() {
		
		Jedis jedis = new Jedis("localhost");
		
	    // 清空数据
	    System.out.println(jedis.flushDB());
	    String key = "mysortset";
	    Map<String, Double> scoreMembers = new HashMap<>();
	    scoreMembers.put("aaa", 1001.0);
	    scoreMembers.put("bbb", 1002.0);
	    scoreMembers.put("ccc", 1003.0);
	    // 添加数据
	    jedis.zadd(key, 1004.0, "ddd");
	    jedis.zadd(key, scoreMembers);
	    // 获取一个排序的集合中的成员数量 4
	    System.out.println(jedis.zcard(key));
	    // 返回的成员在指定范围内的有序集合，以0表示有序集第一个成员，以1表示有序集第二个成员，以此类推。
	    // 负数下标，以-1表示最后一个成员，-2表示倒数第二个成员
	    Set<String> coll = jedis.zrange(key, 0, -1);
	    System.out.println(coll);
	    // 返回的成员在指定范围内的逆序集合
	    coll = jedis.zrevrange(key, 0, -1);
	    System.out.println(coll);
	    // 元素下标
	    System.out.println(jedis.zscore(key, "bbb"));
	    // 删除元素
	    System.out.println(jedis.zrem(key, "aaa"));
	    System.out.println(jedis.zrange(key, 0, -1));
	    // 给定值范围内的成员数
	    System.out.println(jedis.zcount(key, 1002.0, 1003.0));
	}
	
	
	public static void hashTest() {
		
		Jedis jedis = new Jedis("localhost");
	    // 清空数据
	    System.out.println(jedis.flushDB());
	    String key = "myhash";
	    Map<String, String> hash = new HashMap<>();
	    hash.put("aaa", "11");
	    hash.put("bbb", "22");
	    hash.put("ccc", "33");
	    // 添加数据
	    jedis.hmset(key, hash);
	    jedis.hset(key, "ddd", "44");
	    // 获取hash的所有元素(key值)
	    System.out.println(jedis.hkeys(key));
	    // 获取hash中所有的key对应的value值
	    System.out.println(jedis.hvals(key));
	    // 获取hash里所有元素的数量
	    System.out.println(jedis.hlen(key));
	    // 获取hash中全部的域和值,以Map<string, string=""> 的形式返回
	    Map<String, String> elements = jedis.hgetAll(key);
	    System.out.println(elements);
	    // 判断给定key值是否存在于哈希集中
	    System.out.println(jedis.hexists(key, "bbb"));
	    // 获取hash里面指定字段对应的值
	    System.out.println(jedis.hmget(key, "aaa", "bbb"));
	    // 获取指定的值
	    System.out.println(jedis.hget(key, "aaa"));
	    // 删除指定的值
	    System.out.println(jedis.hdel(key, "aaa"));
	    System.out.println(jedis.hgetAll(key));
	    // 为key中的域 field 的值加上增量 increment
	    System.out.println(jedis.hincrBy(key, "bbb", 100));
	    System.out.println(jedis.hgetAll(key));
	}

	public static void main(String[] args) {
		//keyTest();
		//stringTest() ;
		listTest();
		//setTest();
		//zsetTest();
		//hashTest();
	}

}
