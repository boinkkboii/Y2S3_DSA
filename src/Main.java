import java.util.*;
import model.*;
import strategy.*;
import util.GroupLoader;

public class Main {
    public static void main(String[] args) {
        //Insert number of buses and trains to fit the groups in
        int totalBusCapacity;
        int totalTrainCapacity;
        int trainCount;
        int busCount;
        System.out.println("Note: total number of passengers are 1,281");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the total capacity of trains : ");
            totalTrainCapacity = scanner.nextInt();
            trainCount = (int) Math.ceil((double) totalTrainCapacity / 100);
            System.out.print("Enter the total capacity of buses : ");
            totalBusCapacity = scanner.nextInt();
            busCount = (int) Math.ceil((double) totalBusCapacity / 50);
        }
        
        //Load groups from external csv file "groups.csv"
        List<Group> groups = GroupLoader.loadGroups("data/groups.csv");

        //Create and insert both buses and trains into a list
        List<Vehicle> firstFitVehicles = new ArrayList<>(); //List of vehicle for First Fit strategy
        for (int i = 1; i <= trainCount; i++) firstFitVehicles.add(new Train("Train " + i));
        for (int i = 1; i <= busCount; i++) firstFitVehicles.add(new Bus("Bus " + i));
        
        List<Vehicle> bestFitVehicles = new ArrayList<>(); //List of vehicle for Best Fit strategy
        for (int i = 1; i <= trainCount; i++) bestFitVehicles.add(new Train("Train " + i));
        for (int i = 1; i <= busCount; i++) bestFitVehicles.add(new Bus("Bus " + i));

        //Run First Fit Decreasing strategy
        System.out.println("First Fit :");
        BinPackingStrategy ff = new FirstFit();
        List<Vehicle> firstFitResults = ff.pack(new ArrayList<>(groups), new ArrayList<>(firstFitVehicles));
        printResults("First Fit", firstFitResults);

        //Run Best Fit Strategy
        System.out.println("\nBest Fit :");
        BinPackingStrategy bf = new BestFit();
        List<Vehicle> bestFitResult = bf.pack(new ArrayList<>(groups), new ArrayList<>(bestFitVehicles));
        printResults("Best Fit", bestFitResult);
    }

    private static void printResults(String strategy, List<Vehicle> vehicles) {
        int usedVehicles = 0;
        int totalGroups = 0;
        int totalUnusedSeats = 0;
        int totalPassengers = 0;
        int usedBuses = 0;
        int usedTrains = 0;
        for (Vehicle v : vehicles) {
            if (!v.getAssignedGroups().isEmpty()) {
                System.out.println(v);
                usedVehicles++;
                totalGroups += v.getAssignedGroups().size();
                totalUnusedSeats += v.getRemainingCapacity();
                for (Group g : v.getAssignedGroups()) {
                    totalPassengers += g.getSize();
                }
                if (v instanceof model.Bus) usedBuses++;
                else if (v instanceof model.Train) usedTrains++;
            }
        }
        System.out.println("====================================");
        System.out.println("Summary for " + strategy);
        System.out.println("====================================");
        System.out.println("Total Vehicles Used     : " + usedVehicles);
        System.out.println(" ├── Trains Used        : " + usedTrains);
        System.out.println(" └── Buses Used         : " + usedBuses);
        System.out.println("Total Groups Assigned   : " + totalGroups);
        System.out.println("Total passengers seated : " + totalPassengers);
        System.out.println("Unused Seats            : " + totalUnusedSeats);
    }
}