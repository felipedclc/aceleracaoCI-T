package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // findByAccelerationName: busca candidatos pelo nome da aceleração
    List<User> findAllByCandidatesIdAccelerationName(String nomeAceleracao);

    // findByCompanyId: buscar usuários relacionados com uma empresa
    List<User> findAllByCandidatesIdCompanyId(Long companyId);
}
