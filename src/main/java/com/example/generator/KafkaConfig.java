package com.example.generator;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Builds the properties for the Kafka Producer
 */
public class KafkaConfig {
	
	public Properties getKafkaProps() {
		
		Properties props = new Properties();

		//Assign localhost id
		props.put("bootstrap.servers", "localhost:9092");

		//Set acknowledgements for producer requests.
		props.put("acks", "all");

		//If the request fails, the producer can automatically retry,
		props.put("retries", 0);

		//Specify buffer size in config
		props.put("batch.size", 16384);

		//Reduce the no of requests less than 0
		props.put("linger.ms", 1);

		//The buffer.memory controls the total amount of memory available to the producer for buffering.
		props.put("buffer.memory", 33554432);

		props.put("key.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer",
				"org.apache.kafka.common.serialization.StringSerializer");
	
		return props;
	}
}
