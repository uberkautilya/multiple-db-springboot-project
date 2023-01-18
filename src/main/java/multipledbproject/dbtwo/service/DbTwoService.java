package multipledbproject.dbtwo.service;

import multipledbproject.dbtwo.entity.Content;
import multipledbproject.dbtwo.repository.DbTwoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbTwoService {
    private DbTwoRepository dbTwoRepository;

    public List<Content> findAll() {
        return dbTwoRepository.findAll();
    }
}
