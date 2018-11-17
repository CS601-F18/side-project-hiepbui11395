package hpbui.gamerportal.viewmodel;

public class FollowViewModel {
    private Long id;

    public int getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(int relationshipType) {
        this.relationshipType = relationshipType;
    }

    private int relationshipType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
