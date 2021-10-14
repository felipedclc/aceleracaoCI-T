package com.challenge.entity.challenge;

import com.challenge.entity.acceleration.Acceleration;
import com.challenge.entity.submission.Submission;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.security.Timestamp;
import java.util.List;

@Entity
@Table(name = "challenge")
public class Challenge implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String slug;

    @OneToMany
    List<Acceleration> accelerations;

    @OneToMany
    List<Submission> submissions;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    public Challenge(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

    public Challenge() {
        super();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

}
