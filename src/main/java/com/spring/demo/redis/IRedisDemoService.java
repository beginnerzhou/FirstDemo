package com.spring.demo.redis;

public interface  IRedisDemoService {
	void test();
	
	String getData(String id);
	
	String updateDefault(String id);
	
	String updateDefault1(String id);
}
