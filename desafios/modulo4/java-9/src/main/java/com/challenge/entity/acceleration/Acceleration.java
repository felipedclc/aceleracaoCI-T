package com.challenge.entity.acceleration;

import com.challenge.entity.candidate.Candidate;
import com.challenge.entity.challenge.Challenge;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.security.Timestamp;
import java.util.List;

@Entity
@Table(name = "acceleration")
public class Acceleration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 50)
    private String slug;


    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;

    @OneToMany
    private List<Candidate> candidates;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    public Acceleration(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

    public Acceleration() {
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
}
