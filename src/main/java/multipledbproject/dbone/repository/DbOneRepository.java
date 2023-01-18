package multipledbproject.dbone.repository;

import multipledbproject.dbone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbOneRepository extends JpaRepository<User, Integer> {
}
