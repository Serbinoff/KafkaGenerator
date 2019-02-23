package com.example.generator;

import com.example.generator.services.MessageService;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Generator {

	protected static Logger logger;
	protected static Producer<String,String> kafkaProducer;

	public static void main (String[] args) {
		logger = LoggerFactory.getLogger(Generator.class);

		KafkaConfig config = new KafkaConfig();
		kafkaProducer = new KafkaProducer<>(config.getKafkaProps());

		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			String message = MessageService.getMessageData();
			ProducerRecord<String, String> producerRecord = new ProducerRecord<>("oldKafkaTopic", message);

			kafkaProducer.send(producerRecord, (RecordMetadata metadata, Exception exception) -> {
				if (exception != null)
					exception.printStackTrace();
				else
					logger.info("Message " + message + " is sent to Kafka Topic partition {} offset {}", metadata.partition(), metadata.offset());
			});
		}
		kafkaProducer.close();
	}
}

