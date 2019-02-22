package com.example.generator.services;

import java.util.Random;
import org.json.JSONObject;

public class MessageService {
	public static String getMessageData() {

		Random r = new Random();
		
		JSONObject obj = new JSONObject();
		obj.put("id", r.nextInt(10000000));
		obj.put("price", r.nextInt(10000));
		
		return obj.toString();
	}
}
