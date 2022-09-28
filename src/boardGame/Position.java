
package boardGame;

public class Position {
    private int row;
    private int columm;
    
    public Position(){
    }
    public Position(int row, int columm){
        this.row = row;
        this.columm = columm;
    }

    public int getRow() {
        return row;
    }
    public int getColumm() {
        return columm;
    }


    public void SetValues(int row, int columm){
        this.row = row;
        this.columm = columm;
    }
    
    
}
