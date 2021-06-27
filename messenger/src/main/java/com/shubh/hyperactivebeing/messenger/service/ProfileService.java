package com.shubh.hyperactivebeing.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.shubh.hyperactivebeing.messenger.database.DatabaseClass;
import com.shubh.hyperactivebeing.messenger.model.Profile;

public class ProfileService {

	public ProfileService() {
		Profile profile = new Profile();
		profile.setfName("Shubh");
		profile.setlName("Johri");
		profile.setpName("shubhvj");
		profile.setCreated(new Date());
		profile.setId(1L);
		profiles.put("shuhbvj", profile);
	}

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String pName) {
		return profiles.get(pName);
	}

	public Profile addProfile(Profile p) {
		p.setId(profiles.size() + 1);
		profiles.put(p.getpName(), p);
		return p;

	}

	public Profile updateProfile(Profile profile) {
		if (profile.getpName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getpName(), profile);
		return profile;
	}

	public Profile removeProfile(String pName) {
		return profiles.remove(pName);
	}

}
