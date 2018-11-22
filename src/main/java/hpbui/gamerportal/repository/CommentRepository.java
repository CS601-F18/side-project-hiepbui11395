package hpbui.gamerportal.repository;

import hpbui.gamerportal.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long>, CommentRepositoryCustom {
    Page<Comment> findCommentsByToUserId(long toUserId, Pageable pageable);
}
