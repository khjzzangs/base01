package emartscan.emart.com;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import emartscan.emart.com.model.Device;
import emartscan.emart.com.repositories.DeviceRepository;


/**
 * @see https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
 * @author h.j.kim (hjkim@sptek.co.kr)
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmartScanApiControllerTest {
	
	@Autowired
	private MockMvc mvc; 
	
	@Autowired
	DeviceRepository info;
	
	/**
	 * @brief Controller Test
	 * @throws Exception
	 */
	@Test
	public void CheckCallApi1() throws Exception {
		this.mvc.perform(get("/api/hello"))
				.andExpect( status().isOk() )
				.andExpect( content().string("hello, world") );
		
		List<Device> t = info.findAll();
		
	}
	

}
