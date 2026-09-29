public abstract class chessFigure {
    private String name;
    private String color;
    private char col;
    private int row;

    // creates empty chessFigure object
    public chessFigure(){
    }
    
    // creates chessFigure with a name, color, column, and row
    public chessFigure(String name, String color, char col, int row){
        this.name = name;
        this.color = color;
        this.col = col;
        this.row = row;
    }

    // returns the color of the piece
    public String getColor(){
        return color;
    }

    // returns the current column of the piece
    public char getCol(){
        return col;
    }

    // returns the current row of the piece
    public int getRow(){
        return row;
    }

    // changes current column of the piece
    public void setCol(char col){
        this.col = col;
    }

    // changes current row of the piece
    public void setRow(int row){
        this.row = row;
    }

    public abstract boolean verifyMove(char targetCol, int targetRow);
}
