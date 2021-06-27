package com.shubh.hyperactivebeing.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.shubh.hyperactivebeing.messenger.model.Comment;
import com.shubh.hyperactivebeing.messenger.service.CommentService;

@Path("/") //optional
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	CommentService cs = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId){
		return cs.getAllComments(messageId);
	}
	
	@GET
	public Comment getComment(@PathParam("commentId") long commentId, @PathParam("messageId")long messageId) {
		return cs.getComment(commentId, messageId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return cs.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comment comment) {
		comment.setId(commentId);
		return cs.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public Comment deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return cs.removeComment(messageId, commentId);
	}
}
