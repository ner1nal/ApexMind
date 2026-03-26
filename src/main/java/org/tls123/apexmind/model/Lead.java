package org.tls123.apexmind.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String company;

    @Size(max = 255)
    private String position;

    @NotBlank
    @Size(max = 50)
    private String phone;

    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    @Size(max = 1000)
    @Column(length = 1000)
    private String message;

    private LocalDateTime createdAt;
}
