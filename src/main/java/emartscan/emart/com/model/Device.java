/**
 * 
 */
package emartscan.emart.com.model;

import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hj.kim khj20825@gmail.com
 * @since 2019. 11. 25.
 *
 */
@Entity
@Table(name = "QA_DEVICE_INFO" )
@Setter
@Getter
@ToString
public class Device {
	
	@Id
	@Column(name = "ID" , length = 50, nullable = false)
	private String id; 
	@Column(name = "MODEL" , length = 50, nullable = false)
	private String model;
	@Column(name = "WIFI_MAC" , length = 50, nullable = true)
	private String wifiMac;
	@Column(name = "VERSION" , length = 50, nullable = true)
	private String version;
	@Column(name = "etc" , length = 50, nullable = true)
	private String etc;
	@Column(name = "CATEGORY_CODE" , length = 1, nullable = true)
	private String categoryCode;
	@Column(name = "created" , nullable = false) @JsonFormat(pattern = "yyyy-MM-dd HH:mm" , timezone = "Asia/Seoul")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name = "updated" , nullable = true, updatable = false) 
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm" , timezone = "Asia/Seoul")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;
	
}
