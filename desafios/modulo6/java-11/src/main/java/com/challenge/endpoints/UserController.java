package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.exception.ResourceNotFoundException;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    // PathVariable serve para reconhecer o id do param e o id do método
    public User findById(@PathVariable("id") Long id) {
        return this.userService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    @GetMapping
    public Iterable<User> findAll(@PathParam("accelerationName") String accelerationName,
                                  @PathParam("companyId") Long companyId) {
        if (accelerationName != null) {
            return this.userService.findByAccelerationName(accelerationName);
        }
        if (companyId != null) {
            return this.userService.findByCompanyId(companyId);
        }
        return null;
    }
}
