package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.Relationship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RelationshipRepository extends PagingAndSortingRepository<Relationship, Long>, RelationshipRepositoryCustom {
    Relationship findByIdAccountFromAndIdAccountTo(long idAccountFrom, long idAccountTo);

    Page<Relationship> findByIdAccountToAndTypeAndIdAccountFromNot(Long idAccountTo, int type,
                                                                   Long currentUserId, Pageable pageable);
}
