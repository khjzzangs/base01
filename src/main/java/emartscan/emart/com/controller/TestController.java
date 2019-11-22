package emartscan.emart.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	/**
	 * @brief 추천 카테고리 정보를 가져온다.
	 * @author H.J.Kim (hjkim@sptek.co.kr)
	 * @param qryStr 가변적 매개변수
	 * @return ResponseEntity
	 * @see [참고할 사항]
	 * @since 2019. 10. 10 
	 */
	@GetMapping(value = "index")
	public String Hello(Model model) {
	   model.addAttribute("name", "hjkim");
		return "greeting";
	}
	
}
