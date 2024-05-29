package com.example.springbootjavaandroid.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootjavaandroid.model.Profile;
import com.example.springbootjavaandroid.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/get-details/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable("id") String id) {
        Profile profileDetail = profileService.getProfile(id);
        return ResponseEntity.ok(profileDetail);
    } 

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createProfile(@RequestBody Profile profile) {
        String response = profileService.createProfile(profile);
        return ResponseEntity.ok(response);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateProfile(@RequestBody Profile profile) {
        String response = profileService.updateProfile(profile);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping(value = "/delete-profile/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteProfile(@PathVariable("id") String id) {
        String response = profileService.deleteProfile(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-details")
    public ResponseEntity<List<Profile>> getAllProfile() {
        return ResponseEntity.ok(profileService.getAllProfile());
    }

    @GetMapping("/login/{name}")
    public ResponseEntity<String> login(@PathVariable("name") String name) {
        String response = profileService.login(name);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-detail/{name}")
    public ResponseEntity<Profile> getProfileByName(@PathVariable("name") String name) {
        Profile profileDetail = profileService.getProfileByName(name);
        return ResponseEntity.ok(profileDetail);
    }
}