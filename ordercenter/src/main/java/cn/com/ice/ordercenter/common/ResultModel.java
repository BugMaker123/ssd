package cn.com.ice.ordercenter.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 *
 *@author Hamsun
 * Created on 2020年8月5日
 */
public class ResultModel<T extends Serializable> implements Serializable {

	public static <J extends Serializable> ResultModel<J> createSuccessResult(J object) {
		ResultModel<J> resultModel = new ResultModel<>();
		resultModel.data = object;
		resultModel.code = ResultCode.SUCCESS.code;
		resultModel.msg = ResultCode.SUCCESS.message;
		return resultModel;
	}

	public static <J extends Serializable> ResultModel<J> createFailResult() {
		ResultModel resultModel = new ResultModel();
		resultModel.code = ResultCode.FAILURE.code;
		resultModel.msg = ResultCode.FAILURE.message;
		return resultModel;
	}

	public static <J extends Serializable> ResultModel<J> createResult(ResultCode resultCode) {
		ResultModel resultModel = new ResultModel();
		resultModel.code = resultCode.code;
		resultModel.msg = resultCode.message;
		return resultModel;
	}

	public static <J extends Serializable> ResultModel<J> createResult(ResultCode resultCode, J object) {
		ResultModel<J> resultModel = new ResultModel();
		resultModel.data = object;
		resultModel.code = resultCode.code;
		resultModel.msg = resultCode.message;
		return resultModel;
	}

	public static <J extends Serializable> ResultModel<J> createResult(int code,String msg) {
		ResultModel resultModel = new ResultModel();
		resultModel.code = code;
		resultModel.msg = msg;
		return resultModel;
	}

	private static final long serialVersionUID = 1L;

	private Integer code;

	private String msg;

	private T data;

	public ResultModel(){

	}
	public ResultModel(Integer c, String m){
		this.code = c;
		this.msg = m;
	}

	@JsonProperty("code")
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}

	@JsonProperty("msg")
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@JsonProperty("data")
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
