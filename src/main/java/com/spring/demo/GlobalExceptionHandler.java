package com.spring.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.spring.demo.exception.ErrorCode;
import com.spring.demo.exception.ErrorResult;
import com.spring.demo.exception.ParamException;

//@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * 未处理的一样信息
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
    public Object defaultErrorHandler(HttpServletRequest req, Exception e,HttpServletResponse response) throws Exception {
		response.setStatus(ErrorCode.describe(ErrorCode.InternalServerError.toString()));
        return new ErrorResult(ErrorCode.InternalServerError,"服务器内部错误。");
    }
	
	@ExceptionHandler(value = NoHandlerFoundException.class)  
	@ResponseBody
    public String  defaultErrorHandler1(HttpServletRequest req, Exception e) throws Exception {  
		System.out.println("-------------------------------");
        return "";  
    } 
	
	/**
	 * 自定义异常
	 * @param req
	 * @param pe
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = ParamException.class)
    @ResponseBody
	public ErrorResult paramExptionHandler(HttpServletRequest req, ParamException pe, HttpServletResponse response) throws Exception {
		//System.out.println("-------------------------------");
		response.setStatus(ErrorCode.describe(pe.getCode().toString()));
		return new ErrorResult(pe.getCode(),pe.getMessage());
	}
}
