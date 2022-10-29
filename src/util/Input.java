package src.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Scanner getScanner() {
        return scanner;
    }

    public Input() {
        scanner = new Scanner(System.in);
    }

    //GETTERS AND SETTERS//
    public String getString() {
        System.out.println("Enter a name: ");
        return scanner.nextLine();
    }

    public String getString2() {
        System.out.println("Enter a number: ");
        return scanner.nextLine();
    }

    public String getString(String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public boolean yesNo() {
        System.out.println("So yes or no?");
        String choice = scanner.next().toLowerCase();
//        boolean approved = choice.startsWith("y");
//        if (approved) {
//            return true;
//        } else {
//            return false;
//        }
        return choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes");
    }

    public int getInt(int min, int max) {
        String choice = "yes";
        int value = 0;

        while (choice.equalsIgnoreCase("yes")) {
            System.out.printf("Enter a number between %d and %d:%n", min, max);
            value = scanner.nextInt();
            if (value <= max && value >= min) {
                System.out.println("GOOD JOB!");
            } else {
                System.out.println("NOPE THAT'S NOT IT!");
            }
            System.out.println("Continue? (yes/no): ");
            choice = scanner.next();
            System.out.println();
        }
        return value;
    }

        public int getInt () {
            System.out.println("Give me another number, hurry!");
            return scanner.nextInt();
        }

//        public double getDouble (double min, double max){
//            String choice = "yes";
//            double value = 0.00;
//
//            while (choice.equalsIgnoreCase("yes")) {
//                System.out.printf("Enter a number between %.2f and %.2f:%n", min, max);
//                value = scanner.nextDouble();
//                if (value <= max && value >= min) {
//                    System.out.println("GOOD JOB!");
//                } else {
//                    System.out.println("NOPE THAT'S NOT IT!");
//                }
//                System.out.println("Continue? (yes/no): ");
//                choice = scanner.next();
////                System.out.println();
//            }
//            return scanner.nextDouble();
//        }

    public double getDouble (double min, double max){
        String choice = "yes";
        double value = 0.00;


            System.out.printf("Enter a number between %.2f and %.2f:%n", min, max);
            value = scanner.nextDouble();
            if (value <= max && value >= min) {
                System.out.println("GOOD JOB!");
            } else {
                System.out.println("NOPE THAT'S NOT IT!");
            }
            System.out.println("Continue? (yes/no): ");
            choice = scanner.next() + scanner.nextLine();
        System.out.println(choice);
//                System.out.println();
        if (choice.equalsIgnoreCase("yes")){
            getDouble(min, max);
        }
        return value;
    }

        public double getDouble (String prompt) {
            System.out.println(prompt);
            return scanner.nextDouble();
        }


    /////////////////////////////////////////////////////////////////////////  Methods for project ////////////////////////////////////////////////////////////////////////////////////
    static Path p = Paths.get("src", "ContactsProject", "contacts.txt");

//  Gets whats inside the array
        public static List<String> readLines() {
    List<String> names;
    try {
        names = Files.readAllLines(p);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return names;
}



// Loops thourgh the array and outputs
    public static void greetNames() {
            for (String name : readLines()) {
                System.out.printf("%s%n", name);
            }
        }




    // Creates a name and adds it to contacts list
    public static void addNames(String userChoice, String addNum) {
        String fullContactInfo = userChoice + " | " + addNum;
        List<String> addNames = Arrays.asList(fullContactInfo);

        try {
            Files.write(p, addNames, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    // This deletes the names
    public static void deleteName(String nameToDelete) throws IOException {
        List<String> updatedNames = new ArrayList<>();
        for (String name : readLines()) {
            if (!name.contains(nameToDelete)) {
                updatedNames.add(name);
            }
        }
        Files.write(p, updatedNames);
    }




    // This searches through the array
    public static void searchName(String nameToSearch){
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String searchName : lines) {
            if (searchName.contains(nameToSearch)){
                System.out.println(searchName);
            }
        }
    }

    //////////////////////////////////////// End of Methods///////////////////////////////////////////////////////////////////////////////



} // End of Input



