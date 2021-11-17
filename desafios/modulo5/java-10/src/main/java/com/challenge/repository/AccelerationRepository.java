package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

    // buscar acelerações vinculadas com uma empresa
    @Query(value = "select * from ACCELERATION acc " +
            "INNER JOIN CANDIDATE cand " +
            "ON cand.acceleration_id = acc.id " +
            "INNER JOIN COMPANY comp " +
            "ON comp.id = cand.company_id " +
            "where comp.id = :companyId", nativeQuery = true)
    List<Acceleration> findByIdCompanyId(@Param("companyId") Long companyId);

    // findAccelerationByName: buscar uma aceleração pelo nome
    Acceleration findByName(String accelerationName);

}
