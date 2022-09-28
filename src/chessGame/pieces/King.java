
package chessGame.pieces;

import boardGame.Board;
import chessGame.ChessPiece;
import chessGame.Color;

public class King extends ChessPiece{

    public King(Color color, Board board) {
        super(color, board);
    }
    
    @Override
    public String toString(){
        return "K";
    }
}
