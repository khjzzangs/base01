package emartscan.emart.com.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import emartscan.emart.com.model.Device;
import emartscan.emart.com.repositories.DeviceRepository;

@Controller
@RequestMapping("/")
public class DashBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(DashBoardController.class);
	
	@Autowired
	private DeviceRepository repo;
	
	/**
	 * @brief 추천 카테고리 정보를 가져온다.
	 * @author H.J.Kim (hjkim@sptek.co.kr)
	 * @param qryStr 가변적 매개변수
	 * @return ResponseEntity
	 * @see [참고할 사항]
	 * @since 2019. 10. 10 
	 */
	@GetMapping
	public String dashboard(Model model) {
		List<Device> items = repo.findAll();
		model.addAttribute("deviceCnt", items.stream().filter(e -> e.getCategoryCode().equals("D")).collect(Collectors.toList()).size() );
		model.addAttribute("gunsCnt", items.stream().filter(e -> e.getCategoryCode().equals("G")).collect(Collectors.toList()).size() );
		model.addAttribute("batteriesCnt", items.stream().filter(e -> e.getCategoryCode().equals("B")).collect(Collectors.toList()).size() );
		model.addAttribute("totalCnt", items.size() );
		model.addAttribute("name", "hjkim");
		return "index";
	}
	
}
