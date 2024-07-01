package com.pattern.adapter;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class MessagingClient {
	
	private IMsgFormatter msgformatter;
	
	public MessagingClient(IMsgFormatter msgFormatter) {
		this.msgformatter = msgFormatter;
	}

	JSONObject getMessage() throws JSONException {
		return msgformatter.receiveMessage();
	}
	
	public static void main(String[] args) throws JSONException {
		MessagingClient client1 = new MessagingClient(new JSONMsgFormatter());
		System.out.println("Client1 getMessage from JSONMsgForamtter : "  + client1.getMessage().toString(2));
		
		MessagingClient client2 = new MessagingClient(new MsgFormatAdapter());
		System.out.println("Client2 getMessage from MsgFormatAdapter : "  + client2.getMessage().toString(2));
	}
}
