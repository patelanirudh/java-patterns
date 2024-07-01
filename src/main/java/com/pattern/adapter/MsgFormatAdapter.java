package com.pattern.adapter;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class MsgFormatAdapter implements IMsgFormatter {
	
	// Adaptee : composition
	private XMLMsgFormatter xmlMsgFormatter;
	
	public MsgFormatAdapter() {
		xmlMsgFormatter = new XMLMsgFormatter();
	}
	
	@Override
	public JSONObject receiveMessage() throws JSONException {
		String xmlMessage = xmlMsgFormatter.fetchMessage();
		String[] msg = xmlMessage.split(",");
		JSONObject obj = new JSONObject();
		obj.put("name", msg[0]);
		obj.put("requestId", msg[1]);
		return obj;
	}
}
