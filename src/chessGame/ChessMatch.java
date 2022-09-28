package chessGame;

import boardGame.Board;
import boardGame.Position;
import chessGame.pieces.King;
import chessGame.pieces.Rook;

public class ChessMatch {
    
    private Board board;
    
    public ChessMatch(){
        board = new Board(8,8);
        initialSetup();
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
    //
    public void initialSetup(){
        board.placePiece(new Rook(board, Color.WHITE),new Position(0,0));
        board.placePiece(new King(Color.WHITE, board), new Position(0,3));
    }
}
