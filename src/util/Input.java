package src.util;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Input  {

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


    public  boolean yesNo(String prompt) {
        System.out.println(prompt);
        String choice = scanner.next().toLowerCase();
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

//  Gets what's inside the array
        public static List<String> readLines() {
    List<String> names;
    try {
        names = Files.readAllLines(p);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return names;
}



// Loops through the array and outputs
    public static void greetNames() {
            for (String name : readLines()) {
                System.out.printf("%s%n", name);
            }
        }




    // Creates a name and adds it to contacts list
    public void addNames(String userChoice, String addNum) {
            // Created PhoneNum so it can format addNum
        String phoneNum = formatPhoneNum(addNum);
        // We are calling the duplicateContact
        duplicateContact(userChoice);

        try {
            Files.write(p, Arrays.asList(String.format("%-20s | %-20s",userChoice, phoneNum)), StandardOpenOption.APPEND);
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

    // This formats the numbers
    public static String formatPhoneNum(String aNum) {
            String areaCode = null;
            String firstThree = null;
            String lastFour = null;
            if (aNum.length() == 10) {
                areaCode = "(" + aNum.substring(0, 3) + ") ";
                firstThree = aNum.substring(3, 6) + "-";
                lastFour = aNum.substring(6);
            } else if (aNum.length() == 7) {
                areaCode = "(???) ";
                firstThree = aNum.substring(0,3) + "-";
                lastFour = aNum.substring(3);

            }
        return new StringBuilder().append(areaCode).append(firstThree).append(lastFour).toString();
    }


    // Credit to Fernando
    public void duplicateContact(String nameToSearch2){
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(p);
            for (String searchName : lines) {
            if (searchName.contains(nameToSearch2)){
                boolean exist = yesNo("There's already a contact with the same name. Do you want to overwrite it? (yes/no)\n");
                if (exist){
                    duplicateContact(nameToSearch2);
                }
            }
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //////////////////////////////////////// End of Methods///////////////////////////////////////////////////////////////////////////////



} // End of Input



