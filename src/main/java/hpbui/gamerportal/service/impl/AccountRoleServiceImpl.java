package hpbui.gamerportal.service.impl;

import hpbui.gamerportal.entity.AccountRole;
import hpbui.gamerportal.entity.Role;
import hpbui.gamerportal.repository.AccountRepository;
import hpbui.gamerportal.repository.AccountRoleRepository;
import hpbui.gamerportal.repository.RoleRepository;
import hpbui.gamerportal.service.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {
    @Autowired
    AccountRoleRepository accountRoleRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Page<AccountRole> findAccountByRoleName(String roleName, Pageable pageable) {
        Role role = roleRepository.findByRoleName(roleName);
        Page<AccountRole> result = accountRoleRepository.findAccountRoleByIdRole(role.getId(), pageable);
        return result;
    }
}
