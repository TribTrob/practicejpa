package com.codecool.practicejpa;

import com.codecool.practicejpa.entity.Episode;
import com.codecool.practicejpa.entity.Season;
import com.codecool.practicejpa.entity.SeasonNumber;
import com.codecool.practicejpa.entity.Series;
import com.codecool.practicejpa.repository.EpisodeRepository;
import com.codecool.practicejpa.repository.SeasonRepository;
import com.codecool.practicejpa.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class PracticejpaApplication {

    @Autowired
    EpisodeRepository episodeRepository;

    @Autowired
    SeasonRepository seasonRepository;

    @Autowired
    SeriesRepository seriesRepository;


    public static void main(String[] args) {
        SpringApplication.run(PracticejpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(){
        return args -> {
            Set<Episode> episodes = IntStream.range(1,10)
                    .boxed()
                    .map(integer -> Episode.builder().title("Episode"+ integer).actor("Sanyi").actor("Béla").build())
                    .collect(Collectors.toSet());
            Set<Season> seasons = new HashSet<>();

            Season season1 = Season.builder().episodes(episodes).seasonNumber(SeasonNumber.SEASON1).build();
            seasons.add(season1);
            Series sanyi_kalandjai = Series.builder().seriesName("Sanyi Kalandjai").seasons(seasons).build();

            seriesRepository.save(sanyi_kalandjai);


        };
    }

}
