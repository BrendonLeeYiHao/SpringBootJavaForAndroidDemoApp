package com.example.springbootjavaandroid.service;

import java.util.List;

import com.example.springbootjavaandroid.model.Profile;

public interface ProfileService {
    public Profile getProfile(String id);
    public String createProfile(Profile profile);
    public String updateProfile(Profile profile);
    public String deleteProfile(String id);
    public List<Profile> getAllProfile();
    public String login(String name);
    public Profile getProfileByName(String name);
}
