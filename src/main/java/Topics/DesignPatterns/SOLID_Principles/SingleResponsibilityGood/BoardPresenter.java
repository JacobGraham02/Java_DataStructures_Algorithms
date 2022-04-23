package Topics.DesignPatterns.SOLID_Principles.SingleResponsibilityGood;

public class BoardPresenter {
    Board board;

    public BoardPresenter(Board board) {
        this.board = board;
    }

    public void displayBoard() {
        StringBuilder formattedBoard = new StringBuilder();
        for (int i = 0; i < this.board.size * this.board.size; i++) {
            String borderOrNewline = "";
            // Each time the variable i can evenly divide the size of the board, print a new line character.
            if ((i+1) % board.size == 0) {
                borderOrNewline += "\n";
            } else {
                borderOrNewline += "|";
            }
            formattedBoard.append(board.spots.get(i));
            formattedBoard.append(borderOrNewline);
        }
        System.out.println(formattedBoard);
    }
}
