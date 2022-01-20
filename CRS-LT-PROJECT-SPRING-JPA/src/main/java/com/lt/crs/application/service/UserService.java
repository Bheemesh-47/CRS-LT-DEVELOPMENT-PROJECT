/**
 * 
 */
package com.lt.crs.application.service;


import com.lt.crs.application.dto.LoginDto;
import com.lt.crs.application.dto.PasswordDto;
import com.lt.crs.application.dto.StudentDto;
import com.lt.crs.application.entity.Student;
import com.lt.crs.application.entity.User;

/**
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 */

public interface UserService {

	/**
	 * @param student
	 * @return
	 */
	Student saveStudent(StudentDto student);

	/**
	 * @param loginDto
	 * @return
	 */
	User userLogin(LoginDto loginDto);

	/**
	 * @param passwordDto
	 * @return
	 */
	User chnagePassword(PasswordDto passwordDto);
	

}
