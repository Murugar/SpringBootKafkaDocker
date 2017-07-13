package com.iqmsoft.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;


@Slf4j
@Component
public class KafkaMessageProducer {

    private final Random random = new Random();

    @Autowired
    private KafkaTemplate<String, String> template;

    @Scheduled(fixedDelay = 2000)
    public void send() {
       // int partition = random.nextInt(1);
        log.info("Sending message to partition: {}", 0);
        template.send("myTopic", 0, 
        		ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"))
        		.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        
        template.send("myTopic1", 0, 
        		ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"))
        		.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        
        template.send("myTopic2", 0, 
        		ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"))
        		.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        
    }
}
