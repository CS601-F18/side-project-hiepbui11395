package hpbui.gamerportal.service.impl;

import hpbui.gamerportal.entity.Role;
import hpbui.gamerportal.repository.RoleRepository;
import hpbui.gamerportal.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
