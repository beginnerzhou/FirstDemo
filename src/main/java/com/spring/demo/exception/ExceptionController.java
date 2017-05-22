package com.spring.demo.exception;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exce")
public class ExceptionController {
	
	/**
	 * 参数错误
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/param/{name}",method=RequestMethod.GET)
	@ResponseBody
	public String paramerror(@PathVariable String name) throws Exception {
		if(StringUtils.isEmpty(name) || "null".equals(name)){
			 throw new ParamException(ErrorCode.PARAMERROR,"用户名不能为空！");
		}
		
		return "hello world " + name;
	}
	
	/**
	 * 服务器端错误处理
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("null")
	@RequestMapping(value="/server",method=RequestMethod.GET)
	@ResponseBody
	public String servererror() throws Exception {
		Object obj = null  ;
		System.out.println(obj.toString());
		int a = 0,b=0;
		int c = a/b;
		
		return c+""+obj.toString();
	}
}
