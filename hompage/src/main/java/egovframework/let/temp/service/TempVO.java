package egovframework.let.temp.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import egovframework.com.cmm.ComDefaultVO;


public class TempVO extends ComDefaultVO implements Serializable {

	//임시데이터id
	private String tempId;
	//임시데이터 값
	private String tempVal;
	
	//겟셋으로 받아옴
	public String getTempId() {
		return tempId;
	}
	public void setTempId(String tempId) {
		this.tempId = tempId;
	}
	public String getTempVal() {
		return tempVal;
	}
	public void setTempVal(String tempVal) {
		this.tempVal = tempVal;
	}
	
	
}
