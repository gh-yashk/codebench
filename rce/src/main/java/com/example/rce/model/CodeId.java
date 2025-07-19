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
public class CodeId implements Serializable {

    @ManyToOne(optional = false)
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "lang_id")
    private Language language;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CodeId)) {
            return false;
        }
        CodeId codeId = (CodeId) o;
        return Objects.equals(problem.getId(), codeId.problem.getId()) &&
                Objects.equals(language.getId(), codeId.language.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(problem.getId(), language.getId());
    }
}
