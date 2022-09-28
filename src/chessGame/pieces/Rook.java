package chessGame.pieces;

import boardGame.Board;
import chessGame.ChessPiece;
import chessGame.Color;

public class Rook extends ChessPiece{

    public Rook(Board board, Color color) {
        super(color, board);
    }
    
    @Override
    public String toString(){
        return "R";
    }
}
