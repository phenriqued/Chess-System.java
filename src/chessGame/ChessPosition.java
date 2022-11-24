
package chessGame;

import boardGame.Position;

public class ChessPosition {
    private char columm;
    private int row;
    
    public ChessPosition(char columm, int row){
        this.columm = columm;
        this.row = row;
    }

    public char getColumm() {
        return columm;
    }
    public int getRow() {
        return row;
    }
    
    //Returns a new board position, in chess format
    protected Position toPositon(){
        return new Position (8-row,columm - 'a');
    }
    //
    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' + position.getColumm()), 8 - position.getRow());
    }
    
    @Override
    public String toString(){
        return ""+columm+row;
    }
    
}
