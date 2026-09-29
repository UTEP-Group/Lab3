public class Knight extends chessFigure {
    public Knight(String color, char col, int row){
        super("Knight",color,col,row);
    }

    @Override
    public boolean verifyMove(char targetCol, int targetRow){
        int currentRow = this.getRow();
        int currentCol = this.getCol();

        int colDifference = Math.abs(targetCol - currentCol);
        int rowDifference = Math.abs(targetRow - currentRow);

        return (colDifference==2 && rowDifference==1) || (colDifference == 1 && rowDifference == 2);
    }

}
