package model;

public class Group implements Comparable<Group> {
    private String groupId;
    private int groupSize;

    public Group(String groupId, int groupSize) {
        this.groupId = groupId;
        this.groupSize = groupSize;
    }

    public String getId() {
        return groupId;
    }

    public int getSize() {
        return groupSize;
    }

    @Override
    public String toString() {
        return groupId + " (" + groupSize + ")";
    }

    @Override
    public int compareTo(Group other) {
        return Integer.compare(other.getSize(), this.getSize()); // Max heap
    }
}