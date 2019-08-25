package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

@RestController //定义了为controller才能访问地址
@SpringBootApplication // 等价于 @Configuration + @EnableAutoConfiguration + @ComponentScan
@PropertySource("classpath:sea.properties")
@ConfigurationProperties(prefix="sea")
public class DemoApplication {
	
	
	
	//获取配置文件的值
	 @Value("${sea.fuck}") private String name;
	 
	 @Value("${memcache.servers}") private String[] servers;
	 @Value("${memcache.failover}") private boolean failover;
	 @Value("${memcache.initConn}") private int initConn;
	 @Value("${memcache.minConn}") private int minConn; 
	 @Value("${memcache.maxConn}") private int maxConn; 
	 @Value("${memcache.maintSleep}") private int maintSleep; 
	 @Value("${memcache.nagel}") private boolean nagel; 
	 @Value("${memcache.socketTO}") private int socketTO;
	 @Value("${memcache.aliveCheck}") private boolean aliveCheck;
	 
	 @Bean 
	 public SockIOPool sockIOPool () { 
		 SockIOPool pool = SockIOPool.getInstance(); 
		 pool.setServers(servers);
		 pool.setFailover(failover); 
		 pool.setInitConn(initConn); 
		 pool.setMinConn(minConn);
		 pool.setMaxConn(maxConn);
		 pool.setMaintSleep(maintSleep);
		 pool.setNagle(nagel);
		 pool.setSocketTO(socketTO);
		 pool.setAliveCheck(aliveCheck);
		 pool.initialize(); return pool; 
	} 
	 
	 @Bean 
	 public MemCachedClient memCachedClient(){
		 return new MemCachedClient();
	}
	
	
 	@RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello world！"+name;
    }
 	
 	
 	 @Autowired
     private StringRedisTemplate stringRedisTemplate;
 	 
     //添加
     @GetMapping(value="/redisAdd")
     public void saveRedis(){
         stringRedisTemplate.opsForValue().set("a","test");
     }
  
     //获取
     @GetMapping(value="/redisGet")
     public String getRedis(){
    	 stringRedisTemplate.opsForValue().set("test", "100",60*10,TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间  
    	 stringRedisTemplate.boundValueOps("test").increment(-1);//val做-1操作  
    	 stringRedisTemplate.opsForValue().get("test");//根据key获取缓存中的val  
    	 stringRedisTemplate.boundValueOps("test").increment(1);//val +1  
    	 stringRedisTemplate.getExpire("test");//根据key获取过期时间  
    	 stringRedisTemplate.getExpire("test",TimeUnit.SECONDS);//根据key获取过期时间并换算成指定单位  
    	 stringRedisTemplate.delete("test");//根据key删除缓存  
    	 stringRedisTemplate.hasKey("546545");//检查key是否存在，返回boolean值  
    	 stringRedisTemplate.opsForSet().add("red_123", "1","2","3");//向指定key中存放set集合  
    	 stringRedisTemplate.expire("red_123",1000 , TimeUnit.MILLISECONDS);//设置过期时间  
    	 stringRedisTemplate.opsForSet().isMember("red_123", "1");//根据key查看集合中是否存在指定数据  
    	 stringRedisTemplate.opsForSet().members("red_123");//根据key获取set集合  
    	 
    	 
         return stringRedisTemplate.opsForValue().get("a");
     }

 	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}

}
