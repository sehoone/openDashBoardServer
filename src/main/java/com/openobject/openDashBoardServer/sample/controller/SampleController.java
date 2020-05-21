package com.openobject.openDashBoardServer.sample.controller;

import java.util.List;

import com.openobject.openDashBoardServer.common.exception.UserNotFoundException;
import com.openobject.openDashBoardServer.sample.domain.SampleUser;
import com.openobject.openDashBoardServer.sample.repository.SampleUserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class SampleController {

    private static final Logger LOG = LoggerFactory.getLogger(SampleController.class);

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!!!";
    public static final String SECURED_TEXT = "Hello from the secured resource!";

    @Autowired
    private SampleUserRepository userRepository;
    
    @RequestMapping(path = "/hello")
    public String sayHello() {
        LOG.info("GET called on /hello resource");
        
        return HELLO_TEXT;
    }

    @RequestMapping(path = "/user/{lastName}/{firstName}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public long addNewUser (@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        SampleUser savedUser = userRepository.save(new SampleUser(firstName, lastName));

        LOG.info(savedUser.toString() + " successfully saved into DB");
        LOG.info("Server jenkins push Test!!");

        return savedUser.getId();
    }

    @GetMapping(path = "/user/{id}")
    public SampleUser getUserById(@PathVariable("id") long id) {

        return userRepository.findById(id).map(user -> {
            LOG.info("Reading user with id " + id + " from database.");
            return user;
        }).orElseThrow(() -> new UserNotFoundException("The user with the id " + id + " couldn't be found in the database."));
    }

    @GetMapping(path = "/user/firstName/{firstName}")
    public List<SampleUser> getUserById(@PathVariable("firstName") String firstName) {

        return userRepository.findByFirstName(firstName);
    }

}
