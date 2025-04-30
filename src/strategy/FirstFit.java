package strategy;

import java.util.*;
import model.Group;
import model.Vehicle;

public class FirstFit implements BinPackingStrategy {
    @Override
    public ArrayList<Vehicle> pack(List<Group> groups, ArrayList<Vehicle> emptyVehicles) {
        PriorityQueue<Group> groupQueue = new PriorityQueue<>();
        groupQueue.addAll(groups);

        while (!groupQueue.isEmpty()) {
            Group group = groupQueue.poll();
            boolean placed = false;
            for (Vehicle v : emptyVehicles) {
                if (v.canFit(group)) {
                    v.assignGroup(group);
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                System.out.println("Group " + group.getGroupId() + " could not be assigned.");
            }
        }

        return emptyVehicles;
    }
}
