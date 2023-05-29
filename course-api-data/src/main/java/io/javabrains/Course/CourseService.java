package io.javabrains.Course;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
@Autowired
	private CourseRepository courseRepository;
	
	
	
	public List<Course> getAllCourses(String topicId)
	{
		List<Course>course = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(t -> course.add(t));
		return course;
	}
	
	public Optional<Course> getCourseById(String id)
	{
		
		return courseRepository.findById(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
		courseRepository.save(course); 	
		
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);

		
	}

	
	}

