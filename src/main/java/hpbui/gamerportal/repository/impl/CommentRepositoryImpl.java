package hpbui.gamerportal.repository.impl;

import hpbui.gamerportal.repository.CommentRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

public class CommentRepositoryImpl implements CommentRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void updateOverallScore(long toUserId) {
        StoredProcedureQuery query =
                entityManager.createNamedStoredProcedureQuery("updateOverallScore");

        query.registerStoredProcedureParameter(1, Long.class, ParameterMode.IN);
        query.setParameter(1, toUserId);
        query.execute();
    }
}
