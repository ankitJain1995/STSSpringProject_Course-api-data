package io.javabrains.topic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
@Autowired
	private TopicRepository topicRepository;
	
	
	
	public List<Topic> getAllTopic()
	{
		List<Topic>topics = new ArrayList<>();
		topicRepository.findAll().forEach(t -> topics.add(t));
		return topics;
	}
	
//	public Optional<Topic> getTopicById(String id)
//	{
//		return topicRepository.findById(id);
//	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
      topicRepository.deleteById(id);		
	}
	
	

	public Topic getTopicById(String id) {
		// TODO Auto-generated method stub
		return topicRepository.findById(id).get();
	}
}
