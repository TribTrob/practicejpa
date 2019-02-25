package com.codecool.practicejpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Episode {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ElementCollection
    @Singular
    private List<String> actors;

    @ManyToOne
    private Season season;

}
