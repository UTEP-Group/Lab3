public class Rook extends chessFigure {
    public Rook(String color, char col, int row){
        super("Rook",color,col,row);
    }

    @Override
    public boolean verifyMove(char targetCol, int targetRow){
        int currentRow = this.getRow();
        int currentCol = this.getCol();
        return (targetCol==currentCol) || (targetRow==currentRow);
    }
}
