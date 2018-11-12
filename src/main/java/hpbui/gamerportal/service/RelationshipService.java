package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;
import hpbui.gamerportal.entity.Relationship;

public interface RelationshipService {
    void addFriend(Account accountFrom, Account accountTo);
    Relationship findRelationship(int idAccountFrom, int idAccountTo);
}
