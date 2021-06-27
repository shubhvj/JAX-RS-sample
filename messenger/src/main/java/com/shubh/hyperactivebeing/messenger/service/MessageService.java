package com.shubh.hyperactivebeing.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.shubh.hyperactivebeing.messenger.database.DatabaseClass;
import com.shubh.hyperactivebeing.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Shubh", "Hello"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messageList = new ArrayList<>();
		Calendar cal = Calendar.getInstance();

		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messageList.add(message);
			}
		}
		return messageList;
	}

	public List<Message> getAllMessagesPagination(int start, int size) {
		List<Message> messageList = new ArrayList<Message>(messages.values());
		if (start + size > messages.size())
			return new ArrayList<Message>();
		return messageList.subList(start, start + size);
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message msg) {
		msg.setId(messages.size() + 1);
		messages.put(msg.getId(), msg);
		return msg;

	}

	public Message updateMessage(Message msg) {
		if (msg.getId() == 0) {
			return null;
		}
		Set<Long> keys = messages.keySet();
		if (!keys.contains(msg.getId())) {
			Message m = new Message();
			m.setMessage("Provide a valid ID to update message");
			return m;
		}
		messages.put(msg.getId(), msg);
		return msg;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
