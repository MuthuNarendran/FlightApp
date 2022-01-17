package com.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerListener {
	
	@Autowired
	private UserService userService;
    private static final String TOPIC = "DemoTopic";

    @KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(String airlineName) {
        System.out.println("Consumed JSON Message: " + airlineName);
        userService.sendMessageToUserForBlockedBookings(airlineName);
    }
    
}