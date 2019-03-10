package com.polo.rest.polo.util;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class GsonInstance {

	private static Gson gson;
	
	public GsonInstance() {
		instantiateGson();
	}
	
	public static Gson getGson() {
		if ( null == gson ) {
			instantiateGson();
		}
		return gson;
	}

	private static void instantiateGson() {
		gson = new Gson();
	}
	
	
}
