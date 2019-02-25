package com.codecool.practicejpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated
    private SeasonNumber seasonNumber;

    @ManyToOne
    private Set<Series> series;
}
