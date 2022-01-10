
package com.lt.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.lt.DAO.CourseDAO;
import com.lt.DAO.CourseDAOImpl;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category Spring JDBC Configuration Class
 */

@Configuration
public class SpringJDBCConfiguration {
	/**
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @category DataSource Necessary values required to establish JDBC connection are set here
	 */

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//MySQL database we are using
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");//change url
		dataSource.setUsername("root");//change userid
		dataSource.setPassword("root");//change pwd

		//H2 database
		/*
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");*/
		return dataSource;
	}

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category JdbcTemplate 
 */

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	/*	 @Bean
	  public CourseDAO courseDAO(){
	    CourseDAOImpl couDao = new CourseDAOImpl();
	    couDao.setJdbcTemplate(jdbcTemplate());
	    return couDao;
	  }    */

}
