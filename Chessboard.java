// represents the chessboard and its boundaries
public class Chessboard {
    int MAX_ROW = 8;
    int MIN_ROW = 1;
    char MAX_COL = 'h';
    char MIN_COL = 'a';

    // checks if given column and row are inside the chessboard
    public boolean inChessboard(char column, int row) {
        return (column>= MIN_COL && column <=MAX_COL)&&(row >= MIN_ROW && row <= MAX_ROW);
    }
}
