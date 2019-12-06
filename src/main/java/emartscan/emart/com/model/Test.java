package emartscan.emart.com.model;

import java.io.Serializable;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

@Table(name = "RECOMMENDS_CAT")
public class Test implements Serializable{
	
	private static final long serialVersionUID = 4165017625465232771L;
	
	@Id
	private String id;
	@NotNull
	private String code;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String toString() {
		return "Test [id=" + id + ", code=" + code + "]";
	}
	
	
}
