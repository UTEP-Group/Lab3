public class Queen extends chessFigure {
    // creates a Queen with a color and starting position
    public Queen(String color, char col, int row){
        super("Queen",color,col,row);
    }

    // checks if the Queen can move to the target position
    // the Queen can move horizontally, vertically, or diagonally
    @Override
    public boolean verifyMove(char targetCol, int targetRow){
        int currentRow = this.getRow();
        int currentCol = this.getCol();

        int colDifference = Math.abs(targetCol - currentCol);
        int rowDifference = Math.abs(targetRow - currentRow);

        return ((targetCol == currentCol)||(targetRow==currentRow)) || ((colDifference==rowDifference));
    }
}
