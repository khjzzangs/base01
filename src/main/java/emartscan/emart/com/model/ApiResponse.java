package emartscan.emart.com.model;

import java.io.Serializable;
import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ApiResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private final String message;
	private final HttpStatus status;
	private final Map results;
	
	public ApiResponse(Builder build) {
		this.status = build.status;
		this.message = build.message;
		this.results = build.results;
	}
	
	public static class Builder {
		private String message;
		private HttpStatus status;
		private Map results;
		
		public Builder() { }
		
		public static Builder newInstance() { 
            return new Builder(); 
        } 
  
		
		public Builder setMessage(String message) {
			this.message = message;
			return this;
		}
		
		public Builder setStatus(HttpStatus status) {
			this.status = status;
			return this;
		}
		
		public Builder setResult(Map results) {
			this.results = results; 
			return this;
		}
		
		public ApiResponse build() {
			return new ApiResponse(this);
		}
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public Map getResults() {
		return results;
	}
	
	
}
