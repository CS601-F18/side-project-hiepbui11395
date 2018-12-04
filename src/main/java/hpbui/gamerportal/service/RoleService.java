package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Role;

public interface RoleService {
    /**
     * Find role by roleName
     * @param roleName
     * @return Role
     */
    Role findRoleByRoleName(String roleName);
}
