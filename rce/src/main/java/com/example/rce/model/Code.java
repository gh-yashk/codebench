package com.example.rce.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "codes")
public class Code implements Serializable {

    @EmbeddedId
    private CodeId id;

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String starterCode;

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String wrapper;

    @Column(nullable = false)
    private String mode; // append or prepend

    public Problem getProblem() {
        return id.getProblem();
    }

    public Language getLanguage() {
        return id.getLanguage();
    }
}
