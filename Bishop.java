public class Bishop extends chessFigure {
    // creates a Bishop with a color and starting position
    public Bishop(String color, char col, int row){
        super("Bishop",color,col,row);
    }

    // checks if the Bishop can move to the target position
    // a Bishop can only move diagonally
    @Override
    public boolean verifyMove(char targetCol, int targetRow){
        int currentRow = this.getRow();
        int currentCol = this.getCol();
 
        int colDifference = Math.abs(targetCol - currentCol);
        int rowDifference = Math.abs(targetRow - currentRow);
 
        return colDifference == rowDifference;
    }
}
