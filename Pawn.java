public class Pawn extends chessFigure {
    public Pawn(String color, char col, int row){
        super("Pawn",color,col,row);
    }

    // checks if Pawn can move to target position
    // white Pawns move up one row, black Pawns move down one row
    @Override
    public boolean verifyMove(char targetCol, int targetRow){
        int currentRow = this.getRow();
        int currentCol = this.getCol();
        String currentColor = this.getColor();

        if (currentColor.equalsIgnoreCase("white")) {
            return targetCol == currentCol && targetRow == currentRow + 1;
        }else {
            return targetCol == currentCol && targetRow == currentRow - 1;
        }
    }
}

