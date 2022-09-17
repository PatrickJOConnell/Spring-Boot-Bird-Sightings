package dev.patrickoconnell.birdSightings.bird;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BirdRepository extends JpaRepository<Bird, Long> {
    @Query("Select b from Bird b where b.id = ?1")
    Optional<Bird> findBirdById(Long id);

    @Query("Select birdName, count(birdName) from Bird group by birdName order by birdName asc")
    List<List> findCounts();
}
