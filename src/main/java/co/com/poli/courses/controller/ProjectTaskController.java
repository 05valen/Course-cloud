package co.com.poli.courses.controller;

import co.com.poli.courses.entities.ProjectTask;
import co.com.poli.courses.services.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projectTask")
//@RequiredArgsConstructor
public class ProjectTaskController {

    @Autowired
    ProjectTaskService projectTaskService;
    //private final ProjectTaskService projectTaskService;

    @GetMapping
    List<ProjectTask> findAll(){
        return projectTaskService.findAll();
    }

    @PutMapping
    ProjectTask save(ProjectTask projectTask){
        return  projectTaskService.save(projectTask);
    }

     @DeleteMapping("/{id}")
    void  deleteById(@PathVariable Long id){

        projectTaskService.deleteById(id);
    }


}
