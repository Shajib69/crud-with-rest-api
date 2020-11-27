package com.shajib.rest.app.services;

import java.util.List;

import com.shajib.rest.app.entity.course;

public interface CourseServices {
	
	public List<course> getCourses();
		
	public course getCourse(int id);

	public course addCourse(course course);

	public course updateCourse(course course);

	public void deleteCourse(int id);

}
