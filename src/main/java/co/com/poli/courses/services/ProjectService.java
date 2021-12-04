package co.com.poli.courses.services;


import co.com.poli.courses.entities.Project;

import java.util.List;

public interface ProjectService {

    List<Project> findAll();
    Project save(Project project);

}
