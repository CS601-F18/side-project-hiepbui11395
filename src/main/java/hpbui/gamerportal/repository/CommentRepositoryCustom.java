package hpbui.gamerportal.repository;

public interface CommentRepositoryCustom {
    /**
     * Call procedure to update overall score of user
     *
     * @param toUserId
     */
    void updateOverallScore(long toUserId);
}
