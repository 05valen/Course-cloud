package co.com.poli.courses;

import co.com.poli.courses.entities.Backlog;
import co.com.poli.courses.entities.Project;
import co.com.poli.courses.repository.ProjectRepository;
import co.com.poli.courses.services.ProjectService;

import co.com.poli.courses.services.ProjectServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ProjectServiceMockTests {

    @Mock
    private ProjectRepository projectRepository;
    private ProjectService projectService;

   @BeforeEach
    public void begin(){
        MockitoAnnotations.openMocks(this);
        projectService = new ProjectServiceImpl(projectRepository);

        Project project= Project.builder()
                .projectName("Banco caja Social")
                .projectIdentifier("67890")
                .description("test1")
                .startDate("2021-10-21")
                .endDate("2021-11-21")
                .backlog( null)
                .build();
        List<Project> projects = projectService.findAll();
        projects.add(project);
        Mockito.when(projects).thenReturn(projects);
    }

    @Test
    public void when_findById_return_Project(){

        List<Project> projects = projectService.findAll();;
        Assertions.not(projects.size() > 1);
    }

}
