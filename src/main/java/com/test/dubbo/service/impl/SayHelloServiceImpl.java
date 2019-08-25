package com.test.dubbo.service.impl;

import com.test.dubbo.service.SayHelloService;

public class SayHelloServiceImpl implements SayHelloService {

	@Override
	public String sayHello(String str) {
		return ">> 大写的hello word ！！"+str;
	}

}
