package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    /**
     * Add Comment
     * @param fromUserId
     * @param toUserId
     * @param text
     * @param score
     * @param parentId
     */
    void addComment(long fromUserId, long toUserId, String text, int score, Long parentId);

    /**
     * Find a Comment by userId
     * @param toUserId
     * @param pageable
     * @return
     */
    Page<Comment> findCommentsByToUserId(long toUserId, Pageable pageable);
}
