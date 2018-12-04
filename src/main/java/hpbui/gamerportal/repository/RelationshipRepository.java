package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.Relationship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RelationshipRepository extends PagingAndSortingRepository<Relationship, Long>, RelationshipRepositoryCustom {
    Relationship findByIdAccountFromAndIdAccountTo(Long idAccountFrom, Long idAccountTo);

    Page<Relationship> findByIdAccountTo(Long idAccountTo, Pageable pageable);
}
