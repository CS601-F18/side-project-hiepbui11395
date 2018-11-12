package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.AccountRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountRoleService {
    Page<AccountRole> findAccountByRoleName(String roleName, Pageable pageable);
}
