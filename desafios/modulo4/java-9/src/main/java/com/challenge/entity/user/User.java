package com.challenge.entity.user;

import com.challenge.entity.candidate.Candidate;
import com.challenge.entity.submission.Submission;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.security.Timestamp;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Email
    @Column(nullable = false, length = 100)
    private String email;

    @NotNull
    @Size(max = 50)
    private String nickname;

    @NotNull
    @NotBlank
    @Size(min = 255)
    private Integer password;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @OneToMany
    private List<Submission> submissios;

    @OneToMany
    private List<Candidate> candidates;

    public User(String fullName, String email, String nickname, Integer password) {
        this.fullName = fullName;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public User() {
        super();
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getPassword() {
        return password;
    }
    public void setPassword(Integer password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}
