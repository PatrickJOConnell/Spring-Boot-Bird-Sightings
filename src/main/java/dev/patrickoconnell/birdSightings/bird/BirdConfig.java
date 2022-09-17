package dev.patrickoconnell.birdSightings.bird;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BirdConfig {
    @Bean
    CommandLineRunner commandLineRunner(BirdRepository repository){
        return args -> {
            Bird sparrow = new Bird(
                    "House Sparrow",
                    "2022-09-11-05-23-55"
            );
            Bird finch = new Bird(
                    "American Goldfinch",
                    "2022-09-10-05-23-55"
            );
            Bird finch2 = new Bird(
                    "American Goldfinch",
                    "2022-06-10-05-23-55"
            );
            Bird finch3 = new Bird(
                    "House Finch",
                    "2022-07-10-05-23-55"
            );
            Bird finch4 = new Bird(
                    "American Goldfinch",
                    "2022-08-10-05-23-55"
            );
            Bird finch5 = new Bird(
                    "Mourning Dove",
                    "2022-07-10-05-23-55"
            );
            Bird finch6 = new Bird(
                    "House Sparrow",
                    "2022-07-10-05-23-55"
            );
            Bird finch7 = new Bird(
                    "House Sparrow",
                    "2022-07-10-05-23-55"
            );
            Bird finch8 = new Bird(
                    "House Sparrow",
                    "2022-07-10-05-23-55"
            );
            Bird finch9 = new Bird(
                    "Cardinal",
                    "2022-07-10-05-23-55"
            );
            Bird finch10 = new Bird(
                    "Red-bellied Woodpecker",
                    "2022-07-10-05-23-55"
            );
            Bird finch11 = new Bird(
                    "Northern Flicker",
                    "2022-07-10-05-23-55"
            );
            Bird finch12 = new Bird(
                    "Red-bellied Woodpecker",
                    "2022-07-10-05-23-55"
            );
            Bird finch13 = new Bird(
                    "Common Yellowthroat",
                    "2022-07-10-05-23-55"
            );
            Bird finch14 = new Bird(
                    "House Sparrow",
                    "2022-07-10-05-23-55"
            );
            Bird finch15 = new Bird(
                    "House Sparrow",
                    "2022-07-10-05-23-55"
            );

            List<Bird> list = new ArrayList<>();
            list.add(sparrow);
            list.add(finch);
            list.add(finch2);
            list.add(finch3);
            list.add(finch4);
            list.add(finch5);
            list.add(finch6);
            list.add(finch7);
            list.add(finch8);
            list.add(finch9);
            list.add(finch10);
            list.add(finch11);
            list.add(finch12);
            list.add(finch13);
            list.add(finch14);
            list.add(finch15);

            repository.saveAll(list);
        };

    }
}
