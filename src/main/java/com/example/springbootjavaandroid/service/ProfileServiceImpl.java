package com.example.springbootjavaandroid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootjavaandroid.exception.HandleBadRequestException;
import com.example.springbootjavaandroid.exception.HandleNotFoundException;
import com.example.springbootjavaandroid.model.Profile;
import com.example.springbootjavaandroid.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile getProfile(String id) {
        try {
            return profileRepository.findById(id).get();
        } catch (Exception ex) {
            throw new HandleNotFoundException("Profile with ID " + id + " Not Found", ex);
        }
    }

    @Override
    public String createProfile(Profile profile) {
        try {
            profileRepository.save(profile);
            return "New Profile Created Successfully!";
        } catch (Exception ex) {
            throw new HandleBadRequestException("", ex);
        }
    }

    @Override
    public String updateProfile(Profile profile) {
        try {
            profileRepository.save(profile);
            return "Profile Updated Successfully!";
        } catch (Exception ex) {
            throw new HandleBadRequestException("", ex);
        }
    }

    @Override
    public String deleteProfile(String id) {
        try {
            profileRepository.findById(id).get();
            try {
                profileRepository.deleteById(id);
                return "Profile Deleted Successfully!";
            } catch (Exception ex) {
                throw new HandleNotFoundException("Failed to delete profile with ID " + id, ex);
            }
        } catch (Exception ex) {
            throw new HandleNotFoundException("Profile with ID " + id + " Not Found", ex);
        }
       
    }

    @Override
    public List<Profile> getAllProfile() {
        return profileRepository.findAll();
    }

    @Override
    public String login(String name) {
        Profile profile = profileRepository.findByName(name);
        if (profile != null) {
            return "Login Successfully!";
        }
        else {
            throw new HandleNotFoundException("Incorrect Username");
        }
    }

    @Override
    public Profile getProfileByName(String name) {
        try {
            return profileRepository.findByName(name);
        } catch (Exception ex) {
            throw new HandleNotFoundException("Profile with Name " + name + " Not Found", ex);
        }
    }

}
