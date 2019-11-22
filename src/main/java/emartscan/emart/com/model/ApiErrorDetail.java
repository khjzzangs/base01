package emartscan.emart.com.model;

import java.time.LocalTime;

import lombok.Data;

public class ApiErrorDetail {
	
	private String message;
	private String code;
	private LocalTime timeStamp;
	
	public ApiErrorDetail() {
	}

	public ApiErrorDetail(String message, String code, LocalTime timeStamp) {
		super();
		this.message = message;
		this.code = code;
		this.timeStamp = timeStamp;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "ApiErrorDetail [message=" + message + ", code=" + code + ", timeStamp=" + timeStamp + "]";
	}
	

}
