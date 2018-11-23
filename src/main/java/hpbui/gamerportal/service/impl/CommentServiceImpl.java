package hpbui.gamerportal.service.impl;

import hpbui.gamerportal.entity.Comment;
import hpbui.gamerportal.repository.CommentRepository;
import hpbui.gamerportal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public void addComment(long fromUserId, long toUserId, String text, int score, Long parentId) {
        Timestamp commentTime = new Timestamp(System.currentTimeMillis());
        Comment comment = new Comment(text, score, fromUserId, toUserId, commentTime);
        commentRepository.save(comment);
        commentRepository.updateOverallScore(toUserId);
    }

    @Override
    public Page<Comment> findCommentsByToUserId(long toUserId, Pageable pageable) {
        return commentRepository.findCommentsByToUserId(toUserId, pageable);
    }
}
