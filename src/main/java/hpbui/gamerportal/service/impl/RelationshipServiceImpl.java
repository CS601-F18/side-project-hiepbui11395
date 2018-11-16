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
    public void changeRelationship(Account accountFrom, Account accountTo, int relationshipType) {
        Relationship relationship = this.findRelationship(accountFrom.getId(), accountTo.getId());
        if(relationship == null){
            relationship = new Relationship(
                    accountFrom.getId(),
                    accountTo.getId(),
                    relationshipType
            );
        } else{
            relationship.setType(relationshipType);
        }
        relationshipRepository.save(relationship);
    }

    @Override
    public Relationship findRelationship(int idAccountFrom, int idAccountTo) {
        return relationshipRepository.findByIdAccountFromAndIdAccountTo(idAccountFrom,idAccountTo);
    }
}
