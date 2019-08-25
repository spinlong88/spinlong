package com.example.memcache;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.User;


public class testMemcache {

	public static void main(String[] args) {
		   
		
		
		MemCachedManager cache = MemCachedManager.getInstance();
		
		//保存list
		List<Integer> sea = new ArrayList<Integer>();
		sea.add(1);
		sea.add(2);
		sea.add(3);
		sea.add(4);
		cache.add("sea", sea);
		List<Integer> sea2 = (ArrayList)cache.get("sea");
		for(Integer sea3:sea2){
			System.out.println(sea3);
		}
		
		//保存对象
		User user = new User();
		user.setId(new Long(1));
		user.setAge(0);
		user.setUsername("fuck");
		cache.add("user", user);
		user = (User)cache.get("user");
		System.out.println(user.getUsername());
		
		//保存对象 list
		User user1 = new User();
		user1.setId(new Long(1));
		user1.setAge(0);
		user1.setUsername("fuck2");
		
		User user2 = new User();
		user2.setId(new Long(1));
		user2.setAge(0);
		user2.setUsername("fuck1");
		
		List<User> userList= new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		cache.add("userlist", userList);
		userList = (ArrayList)cache.get("userlist");
		for(User userarray:userList){
			System.out.println(userarray.getUsername());
		}
		
		//保存字符串 数字
		MemCachedManager cache2 = MemCachedManager.getInstance();
		cache2.add("sea2", "fuck");
		System.out.println("get value1 : " + cache2.get("sea2"));
		cache2.replace("sea2", "fuck2");
		System.out.println("get value2 : " + cache2.get("sea2"));
		cache2.add("sea3", 22);
		System.out.println("get value2 : " + cache2.get("sea3"));
	}

}
