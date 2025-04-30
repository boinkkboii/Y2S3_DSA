import java.util.*;
import model.*;
import strategy.*;
import util.GroupLoader;

public class App {
    public static void main(String[] args) {
        List<Group> groups = GroupLoader.loadGroups("data/groups.csv");

        List<Vehicle> buses = new ArrayList<>();
        for (int i = 1; i <= 40; i++) buses.add(new Bus("Bus_" + i));

        System.out.println("First Fit :");
        BinPackingStrategy ffd = new FirstFit();
        List<Vehicle> ffdResult = ffd.pack(new ArrayList<>(groups), new ArrayList<>(buses));
        printResults(ffdResult);

        System.out.println("\nBest Fit :");
        List<Vehicle> busesBF = new ArrayList<>();
        for (int i = 1; i <= 40; i++) busesBF.add(new Bus("Bus_" + i));

        BinPackingStrategy bf = new BestFit();
        List<Vehicle> bfResult = bf.pack(new ArrayList<>(groups), new ArrayList<>(busesBF));
        printResults(bfResult);
    }

    private static void printResults(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            if (!v.getAssignedGroups().isEmpty()) { // Only show used vehicles
                System.out.println(v); // assumes Vehicle.toString() lists vehicle name, capacity, and assigned groups
            }
        }
    }
}
