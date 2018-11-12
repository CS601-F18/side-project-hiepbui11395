package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationshipRepository extends JpaRepository<Relationship, Integer> {
    Relationship findByIdAccountFromAndIdAccountTo(int idAccountFrom, int idAccountTo);
}
