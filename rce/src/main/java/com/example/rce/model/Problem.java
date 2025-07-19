package com.example.rce.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "problems")
public class Problem implements Serializable {

    @Id
    @NonNull
    private Long id;

    private String title;

    @Column(unique = true, nullable = false)
    private String slug;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    private String difficulty; // easy, medium, or hard

}
