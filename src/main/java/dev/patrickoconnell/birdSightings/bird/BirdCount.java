package dev.patrickoconnell.birdSightings.bird;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BirdCount {

    private String birdName;
    private long birdCount;

    public BirdCount(String birdName, long birdCount) {
        this.birdName = birdName;
        this.birdCount = birdCount;
    }


    @Override
    public String toString() {

        return "BirdCount{" +
                "birdName='" + birdName + '\'' +
                ", birdCount="+birdCount+
                '}';
    }
}
