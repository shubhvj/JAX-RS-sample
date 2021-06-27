package com.shubh.hyperactivebeing.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.shubh.hyperactivebeing.messenger.model.Message;
import com.shubh.hyperactivebeing.messenger.resources.beans.MessageFilterBean;
import com.shubh.hyperactivebeing.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService ms = new MessageService();

	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean messageBean) {
		if (messageBean.getYear() > 0) {
			return ms.getAllMessagesForYear(messageBean.getYear());
		}
		if (messageBean.getStart() > 0 && messageBean.getSize() > 0) {
			return ms.getAllMessagesPagination(messageBean.getStart(), messageBean.getSize());
		}
		return ms.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId) {
		return ms.getMessage(messageId);
	}

	@POST
	public Message addMessage(Message message) {
		return ms.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return ms.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void removeMessage(@PathParam("messageId") long messageId) {
		ms.removeMessage(messageId);
	}
	
	@GET
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
