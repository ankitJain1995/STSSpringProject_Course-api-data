package io.javabrains.Course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.topic.Topic;

@RestController
public class CourseController {
	
    @Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return courseService.getAllCourses(id);
	}
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourseById(@PathVariable String id)
	{
		return courseService.getCourseById(id);
	}
	
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@PutMapping("topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String id,@PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course); 
	}
	
	@DeleteMapping("topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id)
	{
		courseService.deleteCourse(id);
	}
	
}

