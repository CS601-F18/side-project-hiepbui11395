package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Relationship;

public interface RelationshipService {
    void changeRelationship(Account accountFrom, Account accountTo, int relationshipType);
    Relationship findRelationship(int idAccountFrom, int idAccountTo);
}
