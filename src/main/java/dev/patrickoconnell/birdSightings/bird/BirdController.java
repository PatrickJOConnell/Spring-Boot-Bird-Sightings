package dev.patrickoconnell.birdSightings.bird;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bird")
public class BirdController {

    private final BirdService birdService;
    @Autowired
    public BirdController(BirdService birdService){
        this.birdService = birdService;
    }

    @GetMapping
    public List<Bird> getBirds(){

        return birdService.getBirds();
    }

    @GetMapping(path = "counts")
    public List<BirdCount> getCounts()  {
        List<BirdCount> birdCountReturn = new ArrayList<BirdCount>();
        List<List> birdCountList = birdService.getCounts();
        for (int i = 0; i < birdCountList.size(); i++) {
            List birdList = birdCountList.get(i);
            String bn = birdList.get(0).toString();
            String count = Long.toString((Long) birdList.get(1));
            BirdCount bc = new BirdCount(birdList.get(0).toString(), (long) birdList.get(1));
            birdCountReturn.add(bc);
        }
        return birdCountReturn;

    }

    @PostMapping
    public void registerNewBird(@RequestBody Bird bird){
        birdService.addNewBird(bird);
    }

    @DeleteMapping(path = "{birdId}")
    public void deleteBird(@PathVariable("birdId") Long birdId){
        birdService.deleteBird(birdId);
    }

    @DeleteMapping()
    public void deleteBird() {
        birdService.resetData();
    }

    @PutMapping(path = "{birdId}")
    public void updateBird(
            @PathVariable("birdId") Long birdId,
            @RequestParam(required = false) String birdName,
            @RequestParam(required = false) String dos
    ){
        birdService.updateBird(birdId, birdName);
    }
}
