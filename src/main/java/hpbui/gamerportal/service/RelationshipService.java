package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Relationship;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RelationshipService {
    void changeRelationship(Account accountFrom, Account accountTo, int relationshipType);

    Relationship findRelationship(Long idAccountFrom, Long idAccountTo);

    List<Account> findFriend(Long accountId, Pageable pageable);
}
