package com.challenge.entity.candidate;

import com.challenge.entity.acceleration.Acceleration;
import com.challenge.entity.company.Company;
import com.challenge.entity.user.User;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CandidateIdentity implements Serializable {

    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private Acceleration acceleration;

    @ManyToOne
    @NotNull
    private Company company;

    public User getUser() {
        return user;
    }

    public Acceleration getAcceleration() {
        return acceleration;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateIdentity that = (CandidateIdentity) o;
        return Objects.equals(user, that.user) && Objects.equals(acceleration, that.acceleration) && Objects.equals(company, that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, acceleration, company);
    }
}
