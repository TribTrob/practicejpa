package com.codecool.practicejpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {

    @Id
    @GeneratedValue
    private Long id;

    private String seriesName;

    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Season season;
}
