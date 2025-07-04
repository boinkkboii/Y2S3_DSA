# Group Allocation System Using Bin Packing Strategies
This project is a Java application designed to simulate the allocation of groups of passengers to various transport vehicles using bin packing strategies. It was developed as part of a university-level Data Structures and Algorithms (DSA) course. The system models real-world scenarios such as seating groups in buses or trains using efficient strategies to optimize space utilization.

# Project Objectives
- Implement and compare bin packing strategies including:
  - First Fit
  - Best Fit
- Model vehicles and groups with object-oriented design.
- Load group data dynamically from CSV files.
- Evaluate packing performance in terms of vehicle utilization.

# Features
- Object-oriented design with encapsulated Group, Vehicle, Bus, and Train models.
- Multiple strategy implementations under a unified interface (BinPackingStrategy).
- Dynamic group loading from groups.csv.
- Console-based output of allocation results.
- Extendable architecture for future strategies or transport types.

# File Structure
Y2S3_DSA-main/
│
├── data/
│   └── groups.csv                 # Input data for group sizes
│
├── src/                           # Source code
│   ├── Main.java                  # Entry point
│   ├── model/                     # Entity classes (Bus, Train, Group, Vehicle)
│   ├── strategy/                  # Bin packing strategy implementations
│   └── util/                      # Utility classes (e.g., GroupLoader)
│
├── bin/                           # Compiled class files
├── .vscode/                       # VS Code settings
├── .gitignore
└── README.md

# How to Run
Requirements
- Java Development Kit (JDK) 8 or higher
- IDE such as VS Code, IntelliJ IDEA, or use command-line tools

# - Compile and Run from Terminal
- cd Y2S3_DSA-main/src
- javac Main.java model/*.java strategy/*.java util/*.java
- java Main
- 
# - Run in Visual Studio Code
1. Open the Y2S3_DSA-main folder in VS Code.
2. Ensure the Java extension is installed.
3. Open Main.java.
4. Click Run or press Ctrl + F5.

# Input File Format
The file data/groups.csv contains a list of group sizes to be allocated. Modify this file to test different scenarios.

Sample groups.csv
Group1,5
Group2,10
Group3,8
Each line defines a group name and the number of members.

# Design Overview
- Main.java: Loads the input data and runs the selected allocation strategy.
- model/: Defines core classes such as Group, Vehicle, Bus, and Train.
- strategy/: Contains strategy implementations (FirstFit, BestFit) implementing the BinPackingStrategy interface.
- util/GroupLoader: Reads and parses the input CSV file into Group objects.

# Strategies Implemented
# First Fit
Allocates each group into the first vehicle with sufficient remaining capacity.

# Best Fit
Allocates each group into the vehicle that would have the least leftover space after allocation.
