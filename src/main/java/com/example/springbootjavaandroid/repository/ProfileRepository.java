package com.example.springbootjavaandroid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootjavaandroid.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, String> {

    Profile findByName(String name);
}
