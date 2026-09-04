package week1.class_problems;

import java.util.Random;
import java.util.Scanner;
public class RockPaperScissorsGame {
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];
        int wins = 0;
        int losses = 0;
        int draws = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Rock, Paper or Scissors: ");
            String playerMove = sc.next();
            while (!playerMove.equalsIgnoreCase("Rock") &&
                   !playerMove.equalsIgnoreCase("Paper") &&
                   !playerMove.equalsIgnoreCase("Scissors")) {
                System.out.print("Invalid move. Enter again: ");
                playerMove = sc.next();
            }
            playerMove = playerMove.substring(0, 1).toUpperCase() +
                         playerMove.substring(1).toLowerCase();

            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }
        System.out.println("\nRound\tPlayer Move\tComputer Move\tResult");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "\t" + playerMoves[i] + "\t\t" +
                               computerMoves[i] + "\t\t" + results[i]);
        }
        double winPercentage = (wins / 5.0) * 100;
        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");
        sc.close();
    }
}