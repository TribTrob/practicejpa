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
            Series series = Series.builder().seriesName("Sanyi kalandjai").build();

            Season season = Season.builder()
                    .seasonNumber(SeasonNumber.SEASON1)
                    .series(series)
                    .build();

            Episode episode = Episode.builder()
                    .season(season)
                    .actor("János")
                    .actor("Géza")
                    .title("János és Géza")
                    .build();

            seriesRepository.save(series);

            seasonRepository.save(season);

            episodeRepository.save(episode);
        };
    }

}
