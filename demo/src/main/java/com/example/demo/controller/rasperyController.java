package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class rasperyController {

@GetMapping("/whoami")
public Map<String, String> intro()
{
	Map<String, String> map = new HashMap<>();
    map.put("response", System.getProperty("user.name") );
	return map;
}
///random number
	@GetMapping("/random")
	public Map<String, Integer> random()
	{
		Random r = new Random();
		int random=r.nextInt((200 ) + 1);
		String response="System error : failure detected";
		if(random<100)
			response="No error";

		Map<String, Integer> map = new HashMap<>();

		map.put(response, random);
		return map;
	}
@GetMapping("/time")
public Map<String, String> time()
{
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	Map<String, String> map = new HashMap<>();
	String date=formatter.format(new Date());
    map.put("response", date);
	return map;
}
@GetMapping("/ip")
public Map<String, String> ip()
{
	InetAddress inetAddress;
	Map<String, String> map = new HashMap<>();
	try {
		inetAddress = InetAddress. getLocalHost();
		map.put("IP Address", inetAddress. getHostAddress());
	    map.put("Host Name", inetAddress. getHostName());
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return map;
}



}
