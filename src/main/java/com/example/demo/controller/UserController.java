package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.whalin.MemCached.MemCachedClient;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private User user;
    
    @Autowired
    private MemCachedClient memCachedClient;
    
  //显示用户
    @RequestMapping("query")
    public ModelAndView query() throws Exception {
    	ModelAndView mv = new ModelAndView("/easyui/testEasyUi");
    	List<User> user = userService.getUser();
    	mv.addObject("sea","fuck");
    	
    	 // 放入缓存 
    	boolean flag = memCachedClient.set("a", 1); 
    	// 取出缓存 
    	Object a = memCachedClient.get("a"); 
    	System.out.println(a); 
    	// 3s后过期
    	memCachedClient.set("b", "2", new Date(3000)); 
    	Object b = memCachedClient.get("b"); 
    	System.out.println(b); 
    	Thread.sleep(3000); 
    	b = memCachedClient.get("b"); 
    	System.out.println(b);
    	
    	
        return mv;
    }
    
    
    //显示用户
    @RequestMapping("list")
    public List<User> index() throws Exception {
        return userService.getUser();
    }
    //删除用户
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable int id) throws Exception {
        userService.deleteUser(id);
        return "你已经删掉了id为"+id+"的用户";
    }
    //增加用户
    @RequestMapping("addUser")
    public String addUser() throws Exception {
        user.setAge(33);
        user.setUsername("赖茂龙");
        userService.addUser(user);
        return "增加用户";
    }
}