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

import com.shubh.hyperactivebeing.messenger.model.Profile;
import com.shubh.hyperactivebeing.messenger.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	ProfileService ps = new ProfileService();
	
	@GET
	public List<Profile> getProfiles() {
		return ps.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return ps.getProfile(profileName);
	}

	@POST
	public Profile addProfile(Profile profile) {
		return ps.addProfile(profile);
	}

	@PUT
	@Path("/{profileName}")	
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setpName(profileName);
		return ps.updateProfile(profile);
	}

	@DELETE
	@Path("/{profileName}")
	public void removeProfile(@PathParam("profileName") String profileName) {
		ps.removeProfile(profileName);
	}
}
