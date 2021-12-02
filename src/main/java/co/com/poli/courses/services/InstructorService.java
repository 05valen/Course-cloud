package co.com.poli.courses.services;

import co.com.poli.courses.entities.Instructor;

import java.util.List;

public interface InstructorService {

    List<Instructor> findAll();
    Instructor create(Instructor instructor);
}
