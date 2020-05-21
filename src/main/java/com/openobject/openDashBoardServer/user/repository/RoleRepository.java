package com.openobject.openDashBoardServer.user.repository;

import java.util.Optional;

import com.openobject.openDashBoardServer.user.domain.ERole;
import com.openobject.openDashBoardServer.user.domain.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
