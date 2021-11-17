package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId> {

    // Buscar o maior score de um determinado desafio
    // @Query(value =
            // "select score from SUBMISSION sub " +
            // "INNER JOIN CHALLENGE ch " +
            // "where sub.challenge_id = :challengeId " +
            // "ORDER BY score " +
            // "DESC LIMIT 1 ", nativeQuery = true)
    @Query("select max(score) from Submission s where s.challenge.id.challenge = :challengeId")
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);
    // Submission findFirstByIdChallengeIdOrderByScoreDesc(Long challengeId);

    // buscar submissões de um determinado desafio de uma determinada aceleração
    @Query(value =
            "select * from SUBMISSION sub " +
            "INNER JOIN CHALLENGE ch " +
            "ON ch.id = sub.challenge_id " +
            "INNER JOIN ACCELERATION ac " +
            "ON ac.challenge_id = ch.id " +
            "where ch.id = :challengeId and ac.id = :accelerationId", nativeQuery = true)
        List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,
                                                            @Param("accelerationId") Long accelerationId);
}
