import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        ArrayList<Integer> scoresList = new ArrayList<>();
        String[] menuItems = {
                "1. Add score",
                "2. Show all scores",
                "3. Show highest score",
                "4. Show average score",
                "5. Clear list",
                "6. Exit"};
        while (running) {
            int scoreCount = scoresList.isEmpty() ? 0 : scoresList.size();
            printMenu(scoreCount, menuItems);
            String userInput = scanner.nextLine();
            if (checkInput(userInput, menuItems)) {
                switch (userInput) {
                    case "1": {
                        addScore(scoresList);
                        break;
                    }
                    case "2": {
                        printList(scoresList);
                        break;
                    }
                    case "3": {
                        printHighScore(scoresList);
                        break;
                    }
                    case "4": {
                        printAverageScore(scoresList);
                        break;
                    }
                    case "5": {
                        clearScoreList(scoresList);
                        break;
                    }
                    case "6": {
                        System.out.println("Closing...");
                        running = false;

                    }
                }
            } else {
                System.out.println("Incorrect input, try again...");
            }

        }
    }

    private static void printList(ArrayList<Integer> scoresList) {
        if (!scoresList.isEmpty()) {
            System.out.println("All scores:");
            for (int score : scoresList) {
                System.out.println(score);
            }
        } else {
            System.out.println("Score list is empty...");
        }
    }

    private static void clearScoreList(ArrayList<Integer> scoresList) {
        scoresList.clear();
        System.out.println("List cleared...");
    }

    private static void printAverageScore(ArrayList<Integer> scoresList) {
        if (!scoresList.isEmpty()) {
            int totalScore = 0;
            for (int score : scoresList) {
                totalScore = totalScore + score;
            }
            double averageScore = (double) totalScore / scoresList.size();
            System.out.println("The average score out of a total of " + scoresList.size() + " scores is: " + averageScore);
        } else {
            System.out.println("Score list is empty...");
        }
    }

    private static void printHighScore(ArrayList<Integer> scoresList) {
        int highScore = 0;
        if (!scoresList.isEmpty()) {
            for (int score : scoresList) {
                if (score > highScore) {
                    highScore = score;
                }
            }
            System.out.println("The highest score is: " + highScore);
        } else {
            System.out.println("No scores in list...");
        }
    }

    private static void addScore(ArrayList<Integer> scoresList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a new score: ");
        int newScore = scanner.nextInt();
        scoresList.add(newScore);
        System.out.println(newScore + " added to list.");
        scanner.nextLine();
    }

    private static void printMenu(int scoreCount, String[] menuItems) {
        System.out.println("\n*** Total number of scores in list: " + scoreCount + " ***\n");
        for (String item : menuItems) {
            System.out.println(item);
        }
        System.out.println("Enter:");
    }

    //Loopar igenom meny-arrayen och kollar om user input är ett val som finns
    private static boolean checkInput(String input, String[] menuItems) {
        boolean checkBoolean = false;
        for (int i = 1; i < menuItems.length + 1; i++) {
            if (input.equals(String.valueOf(i))) {
                checkBoolean = true;
                break;
            }
        }
        return checkBoolean;
    }
}