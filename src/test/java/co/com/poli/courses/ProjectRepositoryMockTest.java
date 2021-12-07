package co.com.poli.courses;


import co.com.poli.courses.entities.Backlog;
import co.com.poli.courses.entities.Project;
import co.com.poli.courses.entities.ProjectTask;
import co.com.poli.courses.repository.BacklogRepository;
import co.com.poli.courses.repository.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ProjectRepositoryMockTest {

    @Autowired
    private ProjectRepository projectRepository;
    //   List<Backlog> findAll();
    @Test
    public void when_findAll_return_ListProject(){

        Project project= Project.builder()
        .projectName("f0ge")
       .projectIdentifier("h7f99")
                .description("fsdfdsf")
                .startDate("2021-10-21")
                .endDate("2021-11-21")
                .backlog( null)
                .build();
        projectRepository.save(project);
        List<Project> projects = projectRepository.findAll();
        Assertions.assertThat(projects.size()).isEqualTo(1);

    }

}