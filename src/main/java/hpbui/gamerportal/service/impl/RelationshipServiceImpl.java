package hpbui.gamerportal.service.impl;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Relationship;
import hpbui.gamerportal.repository.RelationshipRepository;
import hpbui.gamerportal.service.RelationshipService;
import hpbui.gamerportal.utils.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationshipServiceImpl implements RelationshipService {
    @Autowired
    RelationshipRepository relationshipRepository;

    @Override
    public void addFriend(Account accountFrom, Account accountTo) {
        Relationship relationship = new Relationship(
                accountFrom.getId(),
                accountTo.getId(),
                Enums.Relationship.PENDING.ordinal(),
                true);
    }

    @Override
    public Relationship findRelationship(int idAccountFrom, int idAccountTo) {
        return relationshipRepository.findByIdAccountFromAndIdAccountTo(idAccountFrom,idAccountTo);
    }
}
