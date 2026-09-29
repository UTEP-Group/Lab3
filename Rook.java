public class Rook extends chessFigure {
    public Rook(String color, char col, int row){
        super("Rook",color,col,row);
    }

    // checks if the Rook can move to the target position
    // a Rook can move in the same row or the same column
    @Override
    public boolean verifyMove(char targetCol, int targetRow){
        int currentRow = this.getRow();
        int currentCol = this.getCol();
        return (targetCol==currentCol) || (targetRow==currentRow);
    }
}
