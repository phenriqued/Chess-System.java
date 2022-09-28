
package boardGame;

public class Piece {
    private Position position;
    protected Board board;
    
    public Piece(){
    }
    public Piece( Board board){
        this.board = board;
        position = null;
    } 
    
    protected Board getBoard(){
        return board;
    }
}
