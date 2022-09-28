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
    
    private void placeNewPiece(char columm, int row, ChessPiece piece){
        board.placePiece(piece,new ChessPosition(columm,  row).toPositon());
    }
    
    //
    public void initialSetup(){
        placeNewPiece('a',8, new Rook(board, Color.BLACK));
        placeNewPiece('h',8, new Rook(board,Color.BLACK));
        placeNewPiece('d',8 ,new King(Color.BLACK, board));
        
        
        
        placeNewPiece('d',1, new King (Color.WHITE,board));
        placeNewPiece('a',1, new Rook(board, Color.WHITE));
        placeNewPiece('h',1, new Rook(board, Color.WHITE));
    }
}
