package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.AccountRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRoleRepository extends PagingAndSortingRepository<AccountRole, Integer> {
    Page<AccountRole> findAccountRoleByIdRole(int idRole, Pageable pageable);
}
