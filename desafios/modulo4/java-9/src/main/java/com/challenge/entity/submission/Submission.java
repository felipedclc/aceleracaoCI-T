package com.challenge.entity.submission;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.security.Timestamp;

@Entity
@Table(name = "submission")
public class Submission implements Serializable {

    @EmbeddedId
    private SubmissionIdentity submissionIdentity;

    @NotNull
    private Float score;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    public SubmissionIdentity getSubmissionIdentity() {
        return submissionIdentity;
    }

    public void setSubmissionIdentity(SubmissionIdentity submissionIdentity) {
        this.submissionIdentity = submissionIdentity;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

}
