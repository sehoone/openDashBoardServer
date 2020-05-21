package com.openobject.openDashBoardServer.sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.openobject.openDashBoardServer.sample.domain.SampleUser;

public interface SampleUserRepository extends CrudRepository<SampleUser, Long> {

    List<SampleUser> findByLastName(@Param("lastname") String lastname);

    List<SampleUser> findByFirstName(@Param("firstname") String firstname);

}
