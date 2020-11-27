package com.shajib.rest.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shajib.rest.app.entity.course;
import com.shajib.rest.app.services.CourseServices;

@RestController
public class Controller {
	
	@Autowired
	private CourseServices courseServices;
	
	@GetMapping("/home")
	public String home() {
		return "hello spring boot !";
	}
	
	// get all courses
	@GetMapping("/courses")
	public List<course> getCourses(){
		return courseServices.getCourses();	
	}
	
	@GetMapping("/courses/{id}")
	public course getCourse(@PathVariable int id){
		return courseServices.getCourse(id);
	}
	
	@PostMapping("/courses")
	public course addCourse(@RequestBody course course) {	
		return this.courseServices.addCourse(course);		
	}
	
	@PutMapping("/courses")
	public course updateCourse(@RequestBody course course) {
		return this.courseServices.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable int id){
		try {
			this.courseServices.deleteCourse(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
