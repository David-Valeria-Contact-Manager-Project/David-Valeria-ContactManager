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

    // This is how we import our Input class
    Input input = new Input();

    //  METHODS ARE IN INPUT CLASS
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
            System.out.println("Name | Phone number");
            System.out.println("------------------");

            switch (userChoice){
                case "1":
                    input.greetNames();
                    break;
                case "2":
                    String addName = input.getString();
                    List<String> newName = new ArrayList<>();
                    String addNum = input.getString2();
                    input.addNames(addName, addNum);

                    break;
                case "3":
                    String search = input.getString();
                    input.searchName(search);
                    break;
                case "4":
                    String deletion = input.getString();
                    input.deleteName(deletion);
                    input.greetNames();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("BE MORE SMARTER! FOLLOW DIRECTIONS");
            }



        } // End of while



    } // End of main
} // End of contacts Manager Project


