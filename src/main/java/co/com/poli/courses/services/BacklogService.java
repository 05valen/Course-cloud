package co.com.poli.courses.services;

import co.com.poli.courses.entities.Backlog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BacklogService {

    List<Backlog> findAll();
    Backlog save(Backlog backlog);



}
