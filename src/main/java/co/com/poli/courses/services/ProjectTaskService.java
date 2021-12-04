package co.com.poli.courses.services;
import co.com.poli.courses.entities.ProjectTask;

import java.util.List;

public interface ProjectTaskService {

    ProjectTask save(ProjectTask projectTask);
    void deleteById(Long id);
    List<ProjectTask> findAll();
}
