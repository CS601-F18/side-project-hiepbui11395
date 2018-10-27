package hpbui.gamerportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hpbui.gamerportal.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByRoleName(String roleName);
}
