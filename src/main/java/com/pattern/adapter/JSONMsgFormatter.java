package com.pattern.adapter;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class JSONMsgFormatter implements IMsgFormatter {
	
	@Override
	public JSONObject receiveMessage() throws JSONException {
		// perform some external API call
		DummyData data = new DummyData("Anirudh", 1001);
		JSONObject obj = new JSONObject();
		obj.put("name", data.getName());
		obj.put("requestId", data.getRequestId());
		return obj;
	}

	// no error for not overriding equals and hashCode as java.lang.Object
	// already has an implementation for them
}
