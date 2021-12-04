package co.com.poli.courses.controller;

import co.com.poli.courses.entities.Project;
import co.com.poli.courses.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
//@RequiredArgsConstructor
public class ProjectController {

    @Autowired
    ProjectService projectService;
    //private final ProjectService projectService;

    @GetMapping
    List<Project> findAll(){
        return projectService.findAll();
    }

    @PostMapping
    Project create(@RequestBody Project project){
        return  projectService.save(project);
    }

}
