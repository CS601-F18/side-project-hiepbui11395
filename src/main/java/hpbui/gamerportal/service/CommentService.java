package hpbui.gamerportal.service;

import hpbui.gamerportal.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    void addComment(long fromUserId, long toUserId, String text, int score, Long parentId);

    Page<Comment> findCommentsByToUserId(long toUserId, Pageable pageable);
}
