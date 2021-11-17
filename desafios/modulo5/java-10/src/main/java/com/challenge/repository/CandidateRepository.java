package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// Usar JpaRepository, pois irá retornar uma List(java), CrudRepository - retorna um Iterable(Java)
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {

    Optional<Candidate> findById(CandidateId id);

    // https://www.amitph.com/spring-data-jpa-embeddedid-partially/
    Optional<Candidate> findByIdUserIdAndIdCompanyIdAndIdAccelerationId(Long userId, Long companyId, Long accelerationId);

    // findByCompanyId: buscar um candidato pelo id da empresa
    @Query(value =
            "select * from CANDIDATE cand " +
            "where cand.company_id = :companyId ", nativeQuery = true)
    // @Query(value = "select * from Candidate c where c.id.company.id = :companyId ")
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);

    // findByAccelerationId: buscar candidatos de uma aceleração
    // @Query(value = "select * from CANDIDATE cand " +
            // "INNER JOIN ACCELERATION acc " +
            // "ON acc.id = cand.acceleration_id " +
            // "where acc.id = :accelerationId", nativeQuery = true)
    @Query("from Candidate c where c.id.acceleration.id = :accelerationId") // HQL
    List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);

}
