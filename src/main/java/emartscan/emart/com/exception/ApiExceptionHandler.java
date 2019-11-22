package emartscan.emart.com.exception;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import emartscan.emart.com.model.ApiErrorDetail;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ApiErrorDetail> handleUserNotFoundException(BadRequestException bre) {
		ApiErrorDetail errorDetail = new ApiErrorDetail();
		errorDetail.setCode("1002");
		errorDetail.setMessage(bre.getMessage());
		errorDetail.setTimeStamp(LocalTime.now());
		return new ResponseEntity<ApiErrorDetail>(errorDetail, HttpStatus.NOT_FOUND);
	}
}
