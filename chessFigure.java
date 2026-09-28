public abstract class chessFigure {
    private String name;
    private String color;
    private char col;
    private int row;

    public chessFigure(){

    }

    
    public chessFigure(String name, String color, char col, int row){
        this.name = name;
        this.color = color;
        this.col = col;
        this.row = row;
    }

    public String getColor(){
        return color;
    }

    public char getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }


    public void setCol(char col){
        this.col = col;
    }

    public void setRow(int row){
        this.row = row;
    }

    public abstract boolean verifyMove();
}

