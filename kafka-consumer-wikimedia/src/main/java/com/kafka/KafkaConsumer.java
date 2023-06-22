package com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private EventRepository eventRepository;



    @KafkaListener(topics = "wikimedia_recentchange",groupId = "MyGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event message received -> %s",eventMessage));
        eventRepository.save(Event.builder().WikimediaData(eventMessage).build());
    }
}
