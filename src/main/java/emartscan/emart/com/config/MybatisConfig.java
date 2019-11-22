package emartscan.emart.com.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class MybatisConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(MybatisConfig.class);

	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariDataSource hikariConfig() {
		return new HikariDataSource();
	}
	
	@Bean
	public DataSource dataSource() throws Exception {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		return dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() throws Exception {
	  return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(
			DataSource dataSource
			) throws Exception {
	  SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	  EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	  factoryBean.setDataSource(dataSource());
	  factoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
	  factoryBean.setConfigLocation(new ClassPathResource("config/mybatis-config.xml"));
	  return factoryBean.getObject();
	}
	
	@Bean
	public SqlSession SqlSessionTemplate(@Autowired SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}