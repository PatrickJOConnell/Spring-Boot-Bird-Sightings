package dev.patrickoconnell.birdSightings.bird;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table
public class Bird {

    @Id
    @SequenceGenerator(name = "bird_sequence",
            sequenceName = "bird_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bird_sequence"
    )
    private Long id;
    private String birdName;

    private LocalDateTime dos;

    public Bird() {
    }

    public Bird(Long id, String birdName, String dos) {
        this.id = id;
        this.birdName = birdName;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime dateTime = LocalDateTime.parse(dos, formatter);
        this.dos = dateTime;

    }

    public Bird(String birdName, String dos) {
        this.birdName = birdName;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime dateTime = LocalDateTime.parse(dos, formatter);
        this.dos = dateTime;
    }

    public Bird(String birdName) {
        this.birdName = birdName;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime dateTime = LocalDateTime.now();
        this.dos = dateTime;
    }

    public Long getId() {
        return id;
    }

    public String getBirdName() {
        return birdName;
    }


    public LocalDateTime getDos() {
        return dos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBirdName(String birdName) {
        this.birdName = birdName;
    }


    public void setDos(LocalDateTime dos) {
        this.dos = dos;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "id=" + id +
                ", birdName='" + birdName + '\'' +
                ", sightingDate=" + dos +
                '}';
    }
}
