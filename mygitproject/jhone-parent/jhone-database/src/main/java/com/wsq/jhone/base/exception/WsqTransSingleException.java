package com.wsq.jhone.base.exception; 
import java.util.HashMap;

import org.apache.log4j.Logger; 
import com.alibaba.fastjson.JSONObject;
import com.wsq.jhone.util.ErrCodeUtil; 
/**
 * @version 1.0
 * @author 温顺全
 * @data 2016-06-08
 * @see public
 * @desc 此类为抛出异常的类，实现了RuntimeException
 */
public class WsqTransSingleException extends WSQBaseRuntimeException {
	private final Logger logger = Logger.getLogger(WsqTransSingleException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -7449371268090950603L;
	private String errCode; // 定义 异常代码
	private String errMessage;// 定义异常消息 
	// 构造 方法
	public WsqTransSingleException(String message) {
		this.errMessage = message;
	}
	/**
	 * 
	 * @param code
	 * @param obj
	 */
	public WsqTransSingleException(String code, Object[] obj) {
		this.errCode = code;
		String desc = ErrCodeUtil.getErrDesc(code, obj);
		logger.info("获取到的错误描述为：【"+desc+"】");
		if ((desc == null) || ("".equals(desc))) {
			if (obj.length > 0)
				this.errMessage = obj[0].toString();
		} else {
			this.errMessage = desc;
		}
	}
	/**
	 * @return json.toString()
	 */
	@Override
	public String getJsonMessage() {
		HashMap<String,String> json = new HashMap<String,String>();
	    json.put("returnCode", getErrCode());
	    json.put("type", "0");
	    json.put("message", getMessage());
	    json.put("url", "");
	    json.put("returnCodeDesc", ErrCodeUtil.getErrSolution(getErrCode()));
	    json.put("advice", "");
	    return JSONObject.toJSONString(json);
	}

	// ==========================================get set // ==============================//
	public String getErrCode() {
		if ((this.errCode == null) || ("".equals(this.errCode))) {
			return "BASE01000";
		}
		return this.errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

}
