package com.challenge.endpoints;

import com.challenge.entity.Submission;
import com.challenge.service.impl.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @GetMapping
    List<Submission> findByChallengeIdAndAccelerationId(@PathParam("challengeId") long challengeId,
                                                        @PathParam("accelerationId") long accelerationId) {
        return submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }
}

