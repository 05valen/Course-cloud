package co.com.poli.courses.repository;
import co.com.poli.courses.entities.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BacklogRepository  extends JpaRepository<Backlog,Long> {

    List<Backlog> findAll();
    Backlog save(Backlog backlog);



}
