package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Account;

public interface RelationshipService {
    void addFriend(Account accountFrom, Account accountTo);
}
