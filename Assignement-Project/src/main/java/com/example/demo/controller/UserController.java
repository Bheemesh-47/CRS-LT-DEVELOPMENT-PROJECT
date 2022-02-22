/**
 * 
 */
package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.exporter.UserExcelExporter;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

/**
 * @author Bheemesh
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService service;
	@GetMapping("/users/export/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		List<User> listUsers = service.listAll();

		UserExcelExporter exporter = new UserExcelExporter();
		exporter.export(listUsers, response);
	}
}
