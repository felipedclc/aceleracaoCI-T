package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.exception.ResourceNotFoundException;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationService accelerationService;

    @GetMapping(value = "/{id}")
    public Acceleration findById(@PathVariable Long id) {
        return accelerationService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aceleração não encontrada"));
    }

    @GetMapping(params = "companyId")
    public List<Acceleration> findAll(@RequestParam("companyId") Long companyId, Pageable pageable) {
        if (companyId != null) {
            return accelerationService.findByCompanyId(companyId);
        }
        return accelerationService.findAll(pageable);
    }
}
