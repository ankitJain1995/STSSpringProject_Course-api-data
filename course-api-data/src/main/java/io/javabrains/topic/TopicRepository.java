package io.javabrains.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
	
	public Topic findByName(String name);

}
