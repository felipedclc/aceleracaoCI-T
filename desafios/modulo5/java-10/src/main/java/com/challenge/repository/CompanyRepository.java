package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    // buscar empresas de uma aceleração
    List<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId);


    // buscar empresas relacionadas com um usuário
    List<Company> findByCandidatesIdUserId(Long userId); // Spring JPA  filter

}
