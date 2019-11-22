/**
 * 
 */
package emartscan.emart.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;

/**
 * @author hj.kim khj20825@gmail.com
 * @since 2019. 11. 20.
 *
 */
@Configuration
public class ViewConfiguration {
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}
}
