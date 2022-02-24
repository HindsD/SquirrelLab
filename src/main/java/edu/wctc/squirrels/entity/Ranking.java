package edu.wctc.squirrels.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Ranking")
public class Ranking {
    @Id
    @Column(name = "ranking_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "squirrel_id")
    private int squirrelId;

    @Min(1)
    @Max(5)
    @Column(name = "ranking")
    private int ranking;

}