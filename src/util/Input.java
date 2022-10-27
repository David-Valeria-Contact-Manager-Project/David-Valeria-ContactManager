package src.util;

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
    }



