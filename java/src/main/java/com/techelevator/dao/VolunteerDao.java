package com.techelevator.dao;

import com.techelevator.model.VolunteerDto;

import java.util.List;

public interface VolunteerDao {
    public VolunteerDto getVolunteer(int volunteerId);
    public List<VolunteerDto> getAllVolunteers();
    public VolunteerDto addVolunteer(VolunteerDto volunteerToAdd);
}
