package co.com.poli.courses.services;

import co.com.poli.courses.entities.Instructor;
import co.com.poli.courses.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    private InstructorRepository repository;

    @Override
    public List<Instructor> findAll() {
        return repository.findAll();
    }

    @Override
    public Instructor create(Instructor instructor) {
        return repository.save(instructor);
    }
}
