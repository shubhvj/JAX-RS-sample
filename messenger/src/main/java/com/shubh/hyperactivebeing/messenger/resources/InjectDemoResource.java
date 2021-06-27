package com.shubh.hyperactivebeing.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("matrix") String matrix, @HeaderParam("header") String header,
			@CookieParam("Cookie_3") String cookie) {
		return matrix + " " + header + " " + cookie;
	}

	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
		return uriInfo.getAbsolutePath() + " " + httpHeaders.getDate();
	}

}
