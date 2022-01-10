
package com.lt.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.bean.Course;
import com.lt.constants.SQLConstants;

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category Course
 * @implSpec CourseDAO
 */

@Repository
public class CourseDAOImpl implements CourseDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}


	/**
	 * Returns list of Courses from the test database. 
	 * @return list of Courses
	 * @param LIST_COURSE is an SQL Constant
	 */
	@SuppressWarnings("deprecation")
	@Override
	public List<Course> listCourses() {
		// TODO Auto-generated method stub

		String sql = SQLConstants.LIST_COURSE;			 
		List<Course> list = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Course obj = new Course();
			obj.setCourseId((int) row.get("CourseID"));
			obj.setCourseName((String) row.get("CourseName"));
			obj.setCourseFee((int) row.get("CourseFee")); 
			list.add(obj);
		}

		return list;
	}
}
