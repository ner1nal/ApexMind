package org.tls123.apexmind.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "survey_answer")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SurveyAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(1) @Max(5) @NotNull
    private Integer q1;
    @Min(1) @Max(5) @NotNull
    private Integer q2;
    @Min(1) @Max(5) @NotNull
    private Integer q3;
    @Min(1) @Max(5) @NotNull
    private Integer q4;
    @Min(1) @Max(5) @NotNull
    private Integer q5;
    @Min(1) @Max(5) @NotNull
    private Integer q6;
    @Min(1) @Max(5) @NotNull
    private Integer q7;
    @Min(1) @Max(5) @NotNull
    private Integer q8;
    @Min(1) @Max(3) @NotNull
    private Integer q9;
    @Min(1) @Max(5) @NotNull
    private Integer q10;

    @Size(max = 255)
    private String company;

    @Size(max = 255)
    private String position;

    private LocalDateTime createdAt;
}