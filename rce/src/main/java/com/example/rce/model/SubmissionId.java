package com.example.rce.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SubmissionId implements Serializable {

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lang_id")
    private Language language;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SubmissionId))
            return false;
        SubmissionId that = (SubmissionId) o;
        return Objects.equals(user.getId(), that.user.getId()) &&
                Objects.equals(problem.getId(), that.problem.getId()) &&
                Objects.equals(language.getId(), that.language.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user.getId(), problem.getId(), language.getId());
    }
}
