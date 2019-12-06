/**
 * 
 */
package emartscan.emart.com.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;

import emartscan.emart.com.model.Device;
import emartscan.emart.com.repositories.DeviceRepository;

/**
 * 점포별 단말기 관리
 * @author hj.kim khj20825@gmail.com
 * @since 2019. 11. 25.
 * 
 */
@Controller
@RequestMapping("device")
public class DeviceController {

	private static final Logger logger = LoggerFactory.getLogger(DashBoardController.class);
	
	@Autowired
	private DeviceRepository baseRepo;

	/**
	 * 전체 부품 조회 화면
	 * @param model
	 * @return
	 */
	@GetMapping("list")
	public String getAllDevice(Model model) {
		List<Device> list = baseRepo.findAll();
		logger.info("device all : ::: {}" , list);
		model.addAttribute("message", "Hello, World !!");
		return "fragments/device/search";
	}
	
	@GetMapping("items")
	@ResponseBody
	public Map getAllItems(Model model) {
		List<Device> list = baseRepo.findAll();
		Map<String, Object> results = Maps.newHashMap();
		results.put("deviceInfo", list.stream().filter(e -> e.getCategoryCode().equals("D")).collect(Collectors.toList()) );
		results.put("gunsInfo", list.stream().filter(e -> e.getCategoryCode().equals("G")).collect(Collectors.toList()) );
		results.put("batteriesInfo", list.stream().filter(e -> e.getCategoryCode().equals("B")).collect(Collectors.toList()) );
		return results;
	}
	
	/**
	 * 단말기 등록 화면
	 * @param model
	 * @param device
	 * @return
	 */
	@GetMapping("register")
	public String register(Model model, final Device device) {
		model.addAttribute("message", "Hello");
		return "fragments/device/register";
	}
	
	/**
	 * 단말기 수정 화면
	 * @param model
	 * @param device
	 * @return
	 */
	@GetMapping("register/{id}")
	public String register(Model model, @PathVariable("id") String id, @ModelAttribute Device device) {
		device = baseRepo.findById(id).get();
		model.addAttribute("device", device);
		return "fragments/device/register";
	}
	
	/**
	 * 건트리거 화면
	 * @param model
	 * @param device
	 * @return
	 */
	@GetMapping("gun/register")
	public String gunRegister(Model model, final Device device) {
		model.addAttribute("device", device);
		return "fragments/device/gunregister";
	}
	
	/**
	 * 배터리 충전 거치대 화면
	 * @param model
	 * @param device
	 * @return
	 */
	@GetMapping("battery/register")
	public String batteryRegister(Model model, final Device device) {
		return "fragments/device/batteryregister";
	}
	
	/**
	 * 단말기 등록
	 * @param device
	 * @return
	 */
	@PostMapping("register")
	public String register(@ModelAttribute Device device) {
		device.setCreated(new Date());
		logger.info("device ::: {} ",  device.toString());
		baseRepo.saveAndFlush(device);
		return "fragments/device/register";
	}
	
}
