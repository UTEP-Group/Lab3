public class Bishop extends chessFigure {
    public Bishop(String color, char col, int row){
        super("Bishop",color,col,row);
    }
 
    @Override
    public boolean verifyMove(char targetCol, int targetRow){
        int currentRow = this.getRow();
        int currentCol = this.getCol();
 
        int colDifference = Math.abs(targetCol - currentCol);
        int rowDifference = Math.abs(targetRow - currentRow);
 
        return colDifference == rowDifference;
    }
}
