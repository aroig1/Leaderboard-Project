import java.util.Scanner;
import java.io.File;

public class LeaderBoard {

    private Contestant board[];

    // n is the number of input people/scores, m is the number of people put on the leaderboard
    public LeaderBoard(int n, int m) throws Exception {
        this.board = new Contestant[m];

        File file = new File("names.txt");
        Scanner scnr = new Scanner(file);
        String input;
        String name;
        int score;

        // Reads in n values and calls to add() function to add them to leaderboard
        for (int i = 0; i < n; ++i) {
            input = scnr.nextLine();
            String[] str = input.split(",");
            name = str[0];
            score = Integer.parseInt(str[1]);

            Contestant temp = new Contestant(name, score);
            this.add(temp);
        }

        scnr.close();

    }

    public void add(Contestant c) {

        // Compares new contestant with the contestants already on the board to see if they can be added
        for (int i = 0; i < board.length; ++i) {

            // Checks for empty slots in leaderboard
            if (board[i] == null) {
                board[i] = c;
                break;
            }

            // Compares if new contestant is greater (higher score or alphabetically) than contestants in leaderboard
            else if (c.compareTo(board[i]) < 0) {
                Contestant temp = board[i];
                board[i] = c;
                // Recursively calls add for contestant that was replaced on leaderboard
                this.add(temp);
                break;
            }
        }
    }

    public Contestant[] finalBoard() {

        // Prints Board (not sure if this function is supposed to print or not)
        for (int i = 0; i < board.length; ++i) {
            System.out.println(board[i].toString());
        }
        
        return this.board;   
    }
}
