package org.tls123.apexmind.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SurveyRequest {

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
    @Min(1) @Max(5) @NotNull
    private Integer q9;
    @Min(1) @Max(5) @NotNull
    private Integer q10;

    @Size(max = 255)
    private String company;

    @Size(max = 255)
    private String position;
}