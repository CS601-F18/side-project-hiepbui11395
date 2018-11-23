package hpbui.gamerportal.repository.impl;

import hpbui.gamerportal.repository.RelationshipRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

public class RelationshipRepositoryImpl implements RelationshipRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void updateNumbefOfFollower(long userId) {
        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("updateNumberOfFollower");

        query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        query.setParameter(1, userId);
        query.execute();
    }
}
