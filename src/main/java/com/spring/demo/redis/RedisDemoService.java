package com.spring.demo.redis;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisDemoService implements IRedisDemoService{
	
	@Resource
	 private RedisTemplate<String,String> redisTemplate; 
	 
	private static String resultdata = "这里是默认的数据";
	
     public void test(){
            ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
            valueOperations.set("mykey4", "random1="+Math.random());
            System.out.println(valueOperations.get("mykey4"));
     }


    @Cacheable(value="andCache",key="#id + 'test'")  //缓存,这里没有指定key.
	@Override
	public String getData(String id) {
		// TODO Auto-generated method stub
    	System.out.println("这是从数据库中取出来的值ddddd:"+id);
		return resultdata;
	}
    
    public String updateDefault1(String id){
    	resultdata = "这里是更新数据123123";
    	return resultdata;
    }
    
    @CacheEvict(value="andCache",key="#id + 'test'")
    public String updateDefault(String id){
    	resultdata = "这里是更新数据";
    	return resultdata;
    }
    
}
