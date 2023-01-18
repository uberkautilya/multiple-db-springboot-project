package multipledbproject.dbtwo.repository;

import multipledbproject.dbtwo.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbTwoRepository extends JpaRepository<Content, Integer> {
}
