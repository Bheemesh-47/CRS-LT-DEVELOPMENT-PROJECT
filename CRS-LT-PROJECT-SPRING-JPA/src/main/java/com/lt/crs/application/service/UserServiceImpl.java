/**
 * 
 */
package com.lt.crs.application.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.crs.application.dto.LoginDto;
import com.lt.crs.application.dto.PasswordDto;
import com.lt.crs.application.dto.StudentDto;
import com.lt.crs.application.entity.Role;
import com.lt.crs.application.entity.Student;
import com.lt.crs.application.entity.User;
import com.lt.crs.application.exception.StudentNotFoundException;
import com.lt.crs.application.exception.UserNotFoundException;
import com.lt.crs.application.repository.ProfessorRepository;
import com.lt.crs.application.repository.StundentRepository;
import com.lt.crs.application.repository.UserRepository;

/**
 * @author deepika, Shiva, Shiva Amancha, Dinesh, Rajneesh, Bheemesh
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	StundentRepository studentRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProfessorRepository professorRepository;
	Student student=null;
/**
 * Student registration method saves the student details into student table if all the details are valid
 */
	@Override
	public Student saveStudent(StudentDto studentDto) {
		if (studentDto == null || studentDto.getStudentName() == null || studentDto.getPassword() == null) {
			System.out.println(studentDto + "       ");
			throw new StudentNotFoundException("Please fill all the required details!! ");
		}
		student=new Student();
		student.setStudentName(studentDto.getStudentName());
		student.setApproved(false);
		student.setPassword(studentDto.getPassword());
		student.setStudentDepartment(studentDto.getStudentDepartment());
		return studentRepository.save(student);
	}
/**
 * Login impl method checks user id and password if matches login successful else throws exception
 */
	@Override
	public User userLogin(LoginDto loginDto) {
		if (loginDto == null || loginDto.getPassword() == null || loginDto.getUserId() == 0) {
			throw new UserNotFoundException("Please enter the valid details!!");
		}
		User user = userRepository.findByIdAndPassword(loginDto.getUserId(), loginDto.getPassword());
		// Set<Role> set = new HashSet<>(user.getRoles());
		

		if (user == null) {
			throw new UserNotFoundException("Login unsucessful ! Please try A again");
		}
		Iterator<Role> iterator=user.getRoles().iterator();
		Role role=new Role();
		while(iterator.hasNext()) {
			role=iterator.next();
		}
		if(role.getId()==2) {
			Student student=studentRepository.findById(user.getId()).get();
			if(!student.isApproved()) {
				throw new UserNotFoundException("Dear user your approval is pending / Rejected by the Admin. Please contact the admin");
			}
		}
		return user;
	}
/**
 * Update password method
 */
	@Override
	public User chnagePassword(PasswordDto passwordDto) {
		if (passwordDto == null || passwordDto.getOldPassword() == null || passwordDto.getUserId() == 0) {
			throw new UserNotFoundException("Please enter the valid details!!");
		}
		User user = userRepository.findByIdAndPassword(passwordDto.getUserId(), passwordDto.getOldPassword());
		if (user == null) {
			throw new UserNotFoundException("Details are not matching ! Please try A again");
		}
		user.setPassword(passwordDto.getNewPassword());

		// finding the user role
		Iterator<Role> iterator = user.getRoles().iterator();
		Role role = new Role();
		while (iterator.hasNext()) {
			role = iterator.next();
		}

		if (role.getName().equalsIgnoreCase("student")) {

			Student student = studentRepository.findById(user.getId()).orElseThrow(() -> new StudentNotFoundException(
					" student is not found with this id" + " " + passwordDto.getUserId()));
			student.setPassword(passwordDto.getNewPassword());
			studentRepository.save(student);
		}
		userRepository.save(user);
		return user;
	}

}
