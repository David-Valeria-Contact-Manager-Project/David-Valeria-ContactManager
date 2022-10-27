package src;

import src.util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class contactsManagerProject {
    // This is the path to contacts.txt
    static Path p = Paths.get("src", "ContactsProject", "contacts.txt");

    // We import it input class
    Input input = new Input();

/////////////////////////////////    Methods ///////////////////////////////////////////////

    // Read contacts.txt
    private static List<String> readLines() {
    List<String> names;
    try {
        names = Files.readAllLines(p);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return names;
}


    // Creates a loop that goes through the array
    private static void greetNames() {
        for (String name : readLines()) {
            System.out.printf("%s%n", name);
        }
    }

    // Creates a name and adds it to contacts list
    private static void addNames(String userChoice) {
        List<String> addNames = Arrays.asList(userChoice);
        try {
            Files.write(p, addNames, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    // This deletes the names
    private static void deleteName(String nameToDelete) throws IOException {
        List<String> updatedNames = new ArrayList<>();
        for (String name : readLines()) {
            if (!name.equalsIgnoreCase(nameToDelete)) {
                updatedNames.add(name);
            }
        }
        Files.write(p, updatedNames);
    }




    // This searches through the array
    private static void searchName(String nameToSearch){
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



//////////////////////////////////////// End of Methods///////////////////////////////////



    public static void main(String[] args) throws IOException {
//        System.out.println(Files.exists(p)); // Path is True


        // This creates the user menu
        Input input = new Input();
        String userChoice = "Yo";
        while (!userChoice.equals("5")) {   // while the user choice does not equal to 5 it can do any of the options
            System.out.println("What would you like to do");
            System.out.println("1 - View contacts");
            System.out.println("2 - Add a new contact");
            System.out.println("3 - Search a contact by name");
            System.out.println("4 - Delete an existing contact");
            System.out.println("5 - Exit ");

            userChoice = input.getString(" Enter an option (1, 2, 3, 4 or 5): ");

            switch (userChoice){
                case "1":
                    greetNames();
                    break;
                case "2":
                    String addName = input.getString();
                    List<String> newName = new ArrayList<>();
                    addNames(addName);
                    break;
                case "3":
                    String search = input.getString();
                    searchName(search);
                    break;
                case "4":
                    String deletion = input.getString();
                    deleteName(deletion);
                    greetNames();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("BE MORE SMARTER! FOLLOW DIRECTIONS");
            }



        } // End of while



    } // End of main
} // End of contacts Manager Project


