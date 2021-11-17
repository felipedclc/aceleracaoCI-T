package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

    // findByAccelerationIdAndUserId: buscar desafios feitos por um usuario em determinada aceleração
    @Query(value =
            "select * from CHALLENGE challenge " +
            "INNER JOIN ACCELERATION acc " +
            "ON acc.challenge_id = challenge.id " +
            "INNER JOIN CANDIDATE cand " +
            "ON cand.acceleration_id = acc.id " +
            "where cand.user_id = :userId AND acc.id = :accelerationId", nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId,
                                                  @Param("userId") Long userId);

}
