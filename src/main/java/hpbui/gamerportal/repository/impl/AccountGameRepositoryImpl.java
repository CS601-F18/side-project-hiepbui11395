package hpbui.gamerportal.repository.impl;

import hpbui.gamerportal.repository.AccountGameRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

public class AccountGameRepositoryImpl implements AccountGameRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void updateNumberOfGamer(long gameId) {
        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("updateNumberOfGamer");

        query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        query.setParameter(1, gameId);
        query.execute();
    }
}
