package com.challenge.entity.candidate;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.security.Timestamp;

@Entity
@Table(name = "candidate")
public class Candidate implements Serializable {

    @EmbeddedId
    private CandidateIdentity candidateIdentity;

    @NotNull
    private Integer status;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }


}
