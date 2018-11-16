package hpbui.gamerportal.viewmodel;

public class FollowViewModel {
    private int id;

    public int getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(int relationshipType) {
        this.relationshipType = relationshipType;
    }

    private int relationshipType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
