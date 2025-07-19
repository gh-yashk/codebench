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
@Table(name = "submissions")
public class Submission implements Serializable {

    @EmbeddedId
    private SubmissionId id;

    @Lob
    @Column(columnDefinition = "TEXT", nullable = false)
    private String userCode;

    @Column(nullable = false)
    private String verdict; // "Accepted" or "Rejected"

    public User getUser() {
        return id.getUser();
    }

    public Problem getProblem() {
        return id.getProblem();
    }

    public Language getLanguage() {
        return id.getLanguage();
    }
}
