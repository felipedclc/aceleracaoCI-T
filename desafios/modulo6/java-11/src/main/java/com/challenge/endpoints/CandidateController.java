package com.challenge.endpoints;

import com.challenge.entity.Candidate;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping(value = "/{userId}/{accelerationId}/{companyId}")
    public Optional<Candidate> findById(@PathVariable("userId") Long userId,
                                        @PathVariable("companyId") Long companyId,
                                        @PathVariable("accelerationId") Long accelerationId) {

        return candidateService.findById(userId, companyId, accelerationId);
    }

    @GetMapping(params = "companyId")
    List<Candidate> findByCompanyId(@RequestParam Long companyId) {
        return this.candidateService.findByCompanyId(companyId);
    }

    @GetMapping(params = "accelerationId")
    List<Candidate> findByAccelerationId(@RequestParam Long accelerationId) {
        return this.candidateService.findByAccelerationId(accelerationId);
    }
}
