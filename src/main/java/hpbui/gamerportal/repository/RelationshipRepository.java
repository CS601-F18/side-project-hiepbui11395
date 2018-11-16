package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.Relationship;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RelationshipRepository extends PagingAndSortingRepository<Relationship, Integer> {
    Relationship findByIdAccountFromAndIdAccountTo(int idAccountFrom, int idAccountTo);

    Page<Relationship> findByIdAccountFrom(int idAccountFrom, Pageable pageable);
}
