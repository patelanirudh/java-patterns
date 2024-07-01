package com.pattern.adapter;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@FunctionalInterface
public interface IMsgFormatter {

	JSONObject receiveMessage() throws JSONException;
	int hashCode();
	boolean equals(Object o); 
}
