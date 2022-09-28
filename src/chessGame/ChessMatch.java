package chessGame;

import boardGame.Board;

public class ChessMatch {
    
    private Board board;
    
    public ChessMatch(){
        board = new Board(8,8);
    }
    
    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumms()];
        for(int r=0;r<board.getRows();r++){
            for(int c=0;c<board.getColumms();c++){
                mat[r][c] = (ChessPiece) board.piece(r,c); 
            }
        }
        return mat;
    } 
}
