package com.iqvia.example;

import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(Sink.class)
public class ItemConsumer {
	
	int count =0;
	
	@StreamListener("input")
	public void Consumeitem(String item) throws ParseException
	{
		count = count + 1;
		System.out.println("count:"+count);
		System.out.println("got the json");
		System.out.println(item);
		convertToJson(item);
	}
	
	public static JSONObject convertToJson(String item) throws ParseException
	{
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(item);
		Set hs = json.keySet();
		System.out.println("Printing set");
		hs.stream().forEach(m -> System.out.println(m));
		return null;
	}
	
	
}
