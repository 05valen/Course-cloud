package co.com.poli.courses;


import co.com.poli.courses.entities.Backlog;
import co.com.poli.courses.entities.Project;
import co.com.poli.courses.entities.ProjectTask;
import co.com.poli.courses.repository.BacklogRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class BacklogRepositoryMockTest {

    @Autowired
    private BacklogRepository backlogRepository;
    //   List<Backlog> findAll();
    @Test
    public void when_findAll_return_ListBacklog(){
        Backlog backlog = Backlog.builder()
                .projectIdentifier("123456")
               // .project(Project.builder().id(1L).build())
                .projectTasks((List<ProjectTask>) ProjectTask.builder().backlog(null).build())
                .build();
        backlogRepository.save(backlog);
        List<Backlog> backlogs = backlogRepository.findAll();
        Assertions.assertThat(backlogs.size()).isEqualTo(2);

    }

}