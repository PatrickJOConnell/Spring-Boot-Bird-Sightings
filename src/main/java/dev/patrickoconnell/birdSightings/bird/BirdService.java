package dev.patrickoconnell.birdSightings.bird;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class BirdService {
    private final BirdRepository birdRepository;

    @Autowired
    public BirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    public List<Bird> getBirds(){
        return birdRepository.findAll();
    }


    public List<List> getCounts(){
        return birdRepository.findCounts();
    }

    public void addNewBird(Bird bird) {
        Optional<Bird> birdOptional = birdRepository.findBirdById(bird.getId());
        if (birdOptional.isPresent()){
            throw new IllegalStateException("id taken");
        }
        birdRepository.save(bird);
    }

    public void deleteBird(Long birdId) {
        boolean exists = birdRepository.existsById(birdId);
        if (!exists){
            throw new IllegalStateException("bird with id " + birdId + " does not exist");
        }
        birdRepository.deleteById(birdId);
    }

    public void resetData() {
        birdRepository.deleteAll();
    }

    @Transactional
    public void updateBird(Long birdId, String birdName) {

        Bird bird = birdRepository.findById(birdId)
                .orElseThrow(() -> new IllegalStateException("bird with id " + birdId + " does not exist"));
        if(birdName != null && birdName.length() > 0){
            bird.setBirdName(birdName);
        }




    }
}
