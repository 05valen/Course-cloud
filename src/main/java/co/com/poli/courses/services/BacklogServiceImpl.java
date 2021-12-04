package co.com.poli.courses.services;

import co.com.poli.courses.entities.Backlog;
import co.com.poli.courses.repository.BacklogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class BacklogServiceImpl implements BacklogService {

    @Autowired
    private BacklogRepository  backlogRepository;
    //private final BacklogRepository backlogRepository;

    @Override
    public List<Backlog> findAll() {
        return backlogRepository.findAll();
        }

    @Override
    public Backlog save(Backlog backlog) {
        return backlogRepository.save(backlog);
    }

}
