package com.spring.demo.exception;


/**
 * 错误码定义
 * @author Administrator
 *
 */
public enum ErrorCode {
	
	/**
	 * 参数错误
	 */
	PARAMERROR(400),
	
	/**
	 * 服务器异常
	 */
	InternalServerError(500),
	
	/**
	 * 资源未访问
	 */
	InternalRequest(404);
	
	private int code;

	private ErrorCode(int code) {
		this.code = code;
	}

	public static int describe(String codeType) {
		for (ErrorCode ty : ErrorCode.values()) {
			if (ty.name().equals(codeType)) {
				return ty.code;
			}
		}
		return -1;
	}
}
