import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        ArrayList<Integer> scoresList = new ArrayList<Integer>();
        printMenu(0);
        while (running) {
            String userInput = scanner.nextLine();
            int scoreCount = scoresList.isEmpty() ? 0 : scoresList.size();
            if (checkInput(userInput)) {

                switch (userInput) {
                    case "1": {
                        addScore(scoresList, scoreCount);
                        printMenu(scoreCount);

                        break;
                    }
                    case "2": {
                        printList(scoresList);
                        printMenu(scoreCount);

                        break;
                    }
                    case "3": {
                        printHighScore(scoresList);
                        break;
                    }
                    case "4": {
                        printAverageScore(scoresList);
                        printMenu(scoreCount);

                        break;
                    }
                    case "5": {
                        clearScoreList(scoresList);
                        printMenu(scoreCount);

                        break;
                    }
                    case "6": {
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

    private static void printList(ArrayList<Integer> scoresList) {
        System.out.println(scoresList.toString());
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
            System.out.println("The average score of " + scoresList.size() + " scores is: " + averageScore);
        } else {
            System.out.println("No scores in list...");
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

    private static void addScore(ArrayList<Integer> scoresList, int scoreCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a new score: ");
        int newScore = scanner.nextInt();
        scoresList.add(newScore);
        scoreCount++;
        System.out.println(newScore + " added to list.");
        scanner.nextLine();
    }

    private static void printMenu(int scoreCount) {
        System.out.println("Total number of scores in list: " + scoreCount);
        System.out.println("1. Add score");
        System.out.println("2. Show list");
        System.out.println("3. Show highest score");
        System.out.println("4. Show average score");
        System.out.println("5. Clear list");
        System.out.println("6. Exit");
        System.out.println("Enter:");
    }

    private static boolean checkInput(String input) {
        return input.equals("1") ||
                input.equals("2") ||
                input.equals("3") ||
                input.equals("4") ||
                input.equals("5") ||
                input.equals("6");
    }
}