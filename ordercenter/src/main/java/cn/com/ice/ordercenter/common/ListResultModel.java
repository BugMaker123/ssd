package cn.com.ice.ordercenter.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 *
 *@author Hamsun
 * Created on 2020年8月5日
 */
public class ListResultModel<T extends Serializable> implements Serializable {

	public static <T extends Serializable> ListResultModel<T> createSuccessResult(List<T> object) {
		ListResultModel<T> resultModel = new ListResultModel<>();
		resultModel.data = object;
		resultModel.code = ResultCode.SUCCESS.code;
		resultModel.msg = ResultCode.SUCCESS.message;
		return resultModel;
	}

	public static <T extends Serializable> ListResultModel<T> createFailResult() {
		ListResultModel<T> resultModel = new ListResultModel<>();
		resultModel.data = Collections.emptyList();
		resultModel.code = ResultCode.INTERNAL_SERVER_ERROR.code;
		resultModel.msg = ResultCode.INTERNAL_SERVER_ERROR.message;
		return resultModel;
	}

	public static <T extends Serializable> ListResultModel<T> createResult(ResultCode resultCode) {
		ListResultModel<T> resultModel = new ListResultModel<>();
		resultModel.data = Collections.emptyList();
		resultModel.code = resultCode.code;
		resultModel.msg = resultCode.message;
		return resultModel;
	}

	public static <T extends Serializable> ListResultModel<T> createResult(ResultCode resultCode,List<T> object) {
		ListResultModel<T> resultModel = new ListResultModel<>();
		resultModel.data = object;
		resultModel.code = resultCode.code;
		resultModel.msg = resultCode.message;
		return resultModel;
	}

	private Integer code;

	private String msg;

	private List<T> data;

	public ListResultModel(){

	}

	public ListResultModel(Integer c, String m){
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
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	
}
