public class King extends chessFigure {
    // creates a King with a color and starting position
    public King(String color, char col, int row){
        super("King",color,col,row);
    }

    // checks if the King can move to the target position
    // the King can move one space in any direction
    @Override
    public boolean verifyMove(char targetCol, int targetRow){
        int currentRow = this.getRow();
        int currentCol = this.getCol();

        int colDifference = Math.abs(targetCol - currentCol);
        int rowDifference = Math.abs(targetRow - currentRow);

        return colDifference<=1&&rowDifference<=1;
    }
}
