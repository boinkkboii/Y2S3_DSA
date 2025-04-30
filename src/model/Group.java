package model;

public class Group {
    private String groupId;
    private int groupSize;

    public Group(String groupId, int groupSize) {
        this.groupId = groupId;
        this.groupSize = groupSize;
    }

    public String getGroupId() {
        return groupId;
    }

    public int getGroupSize() {
        return groupSize;
    }

    @Override
    public String toString() {
        return groupId + " (" + groupSize + ")";
    }
}