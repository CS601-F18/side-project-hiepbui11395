package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Role;

public interface RoleService {
    public Role findRoleByRoleName(String roleName);
}
