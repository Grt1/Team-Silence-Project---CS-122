import java.util.*;
import java.io.*;

public class App {
    public static String userInput;
    public static ArrayList<String> logs = new ArrayList<String>();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter 1 to log an exercise, 2 to log calories, 3 to log hydration.");
        int choice = sc.nextInt();
        if (choice == 1){
            System.out.println("Please log you exercise in this format 'name, time(in hours), intensity(1-10)': ");
            while (true) {
            userInput = sc.nextLine();
            if(isValid(userInput)){
                logs.add(userInput);
                break;
            } else {
                System.out.print("Invalid entry for \"" + userInput + "\". Please try again: ");
                System.out.println("Please log you exercise in this format 'name, time(in hours), intensity(1-10)': ");
            }
        }
        } else if (choice == 2){

        } else if (choice == 3){

        }


        sc.close();
    }   
    private static boolean isValid(String input) {
        try{
        if(Exercise(userInput) == true){
            return !input.isEmpty();
        } else {
            return false;
        }
    } catch ()
    }
}
