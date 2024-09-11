import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int scoreCount = 0;
        ArrayList<Integer> scoresList = new ArrayList<Integer>();
        printMenu(scoreCount);
        String userInput = scanner.nextLine();
        while (running) {
            if (checkInput(userInput)) {
                switch (userInput) {
                    case "1": {
                        addScore();
                    }
                    case "2": {
                        printHighscore(scoresList);
                    }
                    case "3": {
                        printAverageScore(scoresList);
                    }
                    case "4": {
                        clearScoreList(scoresList);
                        System.out.println("List cleared...");
                        printMenu(scoreCount);
                        scanner.nextLine();
                        break;
                    }
                    case "5": {
                        System.out.println("Exiting...");
                        running = false;

                    }
                }
            } else {
                System.out.println("Incorrect input");
                printMenu(scoreCount);
                scanner.nextLine();
            }
        }
    }

    private static void clearScoreList(ArrayList<Integer> scoresList) {
        scoresList.clear();
    }

    private static void printAverageScore(ArrayList<Integer> scoresList) {
        int totalScore = 0;
        for (int score : scoresList) {
            totalScore = totalScore + score;
        }
        double averageScore = (double) totalScore /scoresList.size();
        System.out.println("The average score of " +scoresList.size() +" scores is: " +averageScore);
    }

    private static void printHighscore(ArrayList<Integer> scoresList) {

    }

    private static void addScore() {
    }

    private static void printMenu(int scoreCount) {
        System.out.println("Total number of scores in list: " + scoreCount);
        System.out.println("1. Add score");
        System.out.println("2. Show highest score");
        System.out.println("3. Show average score");
        System.out.println("4. Clear list");
        System.out.println("5. Exit");
        System.out.println("Enter:");
    }

    private static boolean checkInput(String input) {
        return input.equals("1") ||
                input.equals("2") ||
                input.equals("3") ||
                input.equals("4") ||
                input.equals("5");
    }
}