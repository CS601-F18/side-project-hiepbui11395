package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.AccountRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRoleRepository extends PagingAndSortingRepository<AccountRole, Long> {
    Page<AccountRole> findAccountRoleByIdRole(Long idRole, Pageable pageable);
}
