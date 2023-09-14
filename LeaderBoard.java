import java.util.Scanner;
import java.io.File;

public class LeaderBoard {

    private Contestant board[];

    public LeaderBoard(int m) throws Exception {
        this.board = new Contestant[m];

        File file = new File("names.txt");
        Scanner scnr = new Scanner(file);
        String input;
        String name;
        int score;

        for (int i = 0; i < m; ++i) {
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
        // add temp contestant declaration
        int tempScore;
        String tempName;

        for (int i = 0; i < board.length; ++i) {
            if (board[i] == null) {
                board[i] = c;
                break;
            }
            else if (c.compareTo(board[i]) < 0) {
                tempScore = board[i].getScore();
                tempName = board[i].getName();

                board[i].setScore(c.getScore());
                board[i].setName(c.getName());

                Contestant temp = new Contestant(tempName, tempScore);
                this.add(temp);

                // temp = board[i];
                // board[i] = c;
                // this.add(temp);
                break;
            }
        }
    }

    public Contestant[] finalBoard() {
        // Not sure if this is supposed to print or not
        for (int i = 0; i < board.length; ++i) {
            System.out.println(board[i].toString());
        }
        return this.board;   
    }
}
