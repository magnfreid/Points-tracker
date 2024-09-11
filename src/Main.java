import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        ArrayList<String> scoresList = new ArrayList<String>();
        printMenu();
        switch (userInput) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
        }
    }
    private static void printMenu() {
        System.out.println("1. Add score");
        System.out.println("2. Show highest score");
        System.out.println("3. Show average score");
        System.out.println("4. Clear list");
        System.out.println("5. Exit");
    }
}