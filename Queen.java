public class Queen extends chessFigure {
    public Queen(String color, char col, int row){
        super("Queen",color,col,row);
    }

    @Override
    public boolean verifyMove(char targetCol, int targetRow){
        int currentRow = this.getRow();
        int currentCol = this.getCol();

        int colDifference = Math.abs(targetCol - currentCol);
        int rowDifference = Math.abs(targetRow - currentRow);

        return ((targetCol == currentCol)||(targetRow==currentRow)) || ((colDifference==rowDifference));
    }
}
