package com.example.quanlycauthubongdav2.service;

import com.example.quanlycauthubongdav2.entity.Location;
import com.example.quanlycauthubongdav2.repository.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService{
    @Autowired
    private ILocationRepository locationRepository;

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }
}
