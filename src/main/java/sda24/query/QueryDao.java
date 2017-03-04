package sda24.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by RENT on 2017-03-03.
 */
@Repository
public interface QueryDao extends JpaRepository<Query, Integer> {
}
