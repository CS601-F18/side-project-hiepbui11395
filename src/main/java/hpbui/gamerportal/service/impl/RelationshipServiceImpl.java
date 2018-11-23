package hpbui.gamerportal.service.impl;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Relationship;
import hpbui.gamerportal.repository.RelationshipRepository;
import hpbui.gamerportal.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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
        relationshipRepository.updateNumbefOfFollower(accountTo.getId());
    }

    @Override
    public Relationship findRelationship(Long idAccountFrom, Long idAccountTo) {
        return relationshipRepository.findByIdAccountFromAndIdAccountTo(idAccountFrom,idAccountTo);
    }

    @Override
    public List<Account> findFriend(Long accountId, Pageable pageable) {
        List<Account> listAccount = new ArrayList<>();
        Page<Relationship> listRelationship = relationshipRepository.findByIdAccountTo(accountId, pageable);
        for (Relationship relationship : listRelationship) {
            listAccount.add(relationship.getAccountFrom());
        }
        return listAccount;
    }
}
