package co.com.poli.courses.services;


import co.com.poli.courses.entities.ProjectTask;
import co.com.poli.courses.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {


    @Autowired
    private ProjectTaskRepository projectTaskRepository;


    @Override
    public ProjectTask save(ProjectTask projectTask) {
        return projectTaskRepository.save(projectTask);
    }

    @Override
    public void deleteById(Long id) {
        projectTaskRepository.deleteById(id);
    }

    @Override
    public List<ProjectTask> findAll() {
        return null;
    }
}
