package emartscan.emart.com.constants;

import lombok.Getter;

public class EnvEnums {
	
	
	/**
	 * 기본 Enum 예시
	 * @author hj.kim hjkim@spteck.co.kr
	 * @Date 2019. 10. 18.
	 * @Updated 수정자 : 수정내용
	 */
	@Getter 
	public static enum Host { 
		 PROD("prod", "http://localhost")
		,STAGE("stage", "http://localhost")
		,DEV("dev", "http://localhost")
		,LOCAL("local", "http://localhost");
		
		private String profile;
		private String url;
		
		private Host(String url, String profile) {
			this.url = url;
			this.profile = profile;
		}
	}
	
}
