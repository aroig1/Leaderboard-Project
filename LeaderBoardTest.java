import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeaderBoardTest {
    
    public static void main(String[] args) throws Exception {
        LeaderBoard test = new LeaderBoard(50);

        try {
            File file = new File("names2.txt");
            Scanner scnr = new Scanner(file);
            String input;
            String name;
            int score;

            // Reads in n values and calls to add() function to add them to leaderboard
            while (scnr.hasNextLine()) {
                input = scnr.nextLine();
                String[] str = input.split(",");
                name = str[0];
                score = Integer.parseInt(str[1]);

                Contestant temp = new Contestant(name, score);
                test.add(temp);
            }

            scnr.close();

            Contestant[] board = test.finalBoard();

            // Prints Board
            for (int i = 0; i < board.length; ++i) {
                if (board[i] == null) {
                    System.out.println("" + (i + 1) + ". _______________");
                }
                else {
                    System.out.println("" + (i + 1) + ". " + board[i].toString());
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error ocurred reading the file: " + e.getMessage());
        }

    }
}