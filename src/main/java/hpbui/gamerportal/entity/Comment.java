package hpbui.gamerportal.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gamer_portal.comments")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "updateOverallScore",
                procedureName = "gamer_portal.updateOverallScore")})
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "score", nullable = false)
    private int score;

    private long fromUserId;

    private long toUserId;

    private Timestamp commentTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fromUserId", insertable = false, updatable = false)
    private Account fromUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "toUserId", insertable = false, updatable = false)
    private Account toUser;

    @OneToMany(
            mappedBy = "parentComment",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> childComments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId")
    private Comment parentComment;

    public Comment() {
    }

    public Comment(String text, int score, long fromUserId, long toUserId, Timestamp commentTime) {
        this.text = text;
        this.score = score;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.commentTime = commentTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Comment> getChildComments() {
        return childComments;
    }

    public void setChildComments(List<Comment> childComments) {
        this.childComments = childComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    public Account getFromUser() {
        return fromUser;
    }

    public void setFromUser(Account fromUser) {
        this.fromUser = fromUser;
    }

    public Account getToUser() {
        return toUser;
    }

    public void setToUser(Account toUser) {
        this.toUser = toUser;
    }
}
