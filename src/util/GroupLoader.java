package util;
import java.io.*;
import java.util.*;
import model.Group;

public class GroupLoader {
    public static List<Group> loadGroups(String filename) {
        List<Group> groups = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // skip header
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 3) 
                    continue;

                String id = parts[0].trim();
                int size = Integer.parseInt(parts[1].trim());
                int quantity = Integer.parseInt(parts[2].trim());

                for (int i = 0; i < quantity; i++) {
                    groups.add(new Group(id + "_" + (i + 1), size)); // unique per instance
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return groups;
    }
}
