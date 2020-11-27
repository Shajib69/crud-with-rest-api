package com.shajib.rest.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shajib.rest.app.entity.course;

@Service
public class CourseServiceImpl implements CourseServices {

	
	List<course> list;
	
	public CourseServiceImpl() {
		
		list = new ArrayList<course>();
		list.add(new course(1,"abc","nothing"));
		list.add(new course(2,"xyz","anything"));
	}
	
	public List<course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}
	
	public course getCourse(int id){
		
		course c = null;
		for(course course:list) {
			if(course.getId() == id) {
				c = course;
				break;
			}
		}
		
		return c;
		
	}

	public course addCourse(course course) {
		list.add(course);
		return course;
	}
	
	public course updateCourse(course course) {
		list.forEach(e -> {
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
		}
		});
		return course;
	}
	
	public void deleteCourse(int id) {
		//list = this.list.stream().filter(e -> e.getId()!=id).collect(collectors.ToList());
		list.removeIf(e ->e.getId()==(id));

	}
	
}
