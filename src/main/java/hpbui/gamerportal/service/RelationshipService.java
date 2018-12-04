package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Relationship;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RelationshipService {
    /**
     * Update relationShip
     * @param accountFrom
     * @param accountTo
     * @param relationshipType
     */
    void changeRelationship(Account accountFrom, Account accountTo, int relationshipType);

    /**
     * Find relationship by userIdFrom and To
     * @param idAccountFrom
     * @param idAccountTo
     * @return
     */
    Relationship findRelationship(Long idAccountFrom, Long idAccountTo);

    /**
     * Find relationship by userId
     * @param accountId
     * @param pageable
     * @return
     */
    List<Account> findFriend(Long accountId, Pageable pageable);
}
