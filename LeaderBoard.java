public class LeaderBoard {

    private Contestant board[];

    // m is the number of people put on the leaderboard
    public LeaderBoard(int m) throws Exception {
        this.board = new Contestant[m];
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
        return this.board;   
    }
}
