package multipledbproject.dbone.service;

import multipledbproject.dbone.entity.User;
import multipledbproject.dbone.repository.DbOneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbOneService {
    private DbOneRepository dbOneRepository;

    public List<User> findAll() {
        return dbOneRepository.findAll();
    }
}
