package com.spring.demo;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.demo.exception.ErrorCode;
import com.spring.demo.exception.ErrorResult;

//@Controller
public class MainsiteErrorController implements ErrorController{
	
	@RequestMapping("error")  
	@ResponseBody
    public ErrorResult handleError(){  
        return new ErrorResult(ErrorCode.InternalRequest,"请求的资源不存在！");
    }

	@Override
	public String getErrorPath() {
		
		// TODO Auto-generated method stub
		return "/error";
	}
}
