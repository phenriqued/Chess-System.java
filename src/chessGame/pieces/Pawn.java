
package chessGame.pieces;

import boardGame.Board;
import boardGame.Position;
import chessGame.ChessPiece;
import chessGame.Color;

public class Pawn extends ChessPiece {

    public Pawn(Color color, Board board) {
        super(color, board);
    }

    @Override
    public String toString() {
        return "P";
    }
    
    

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumms()];
        Position p = new Position (0, 0);
        
        //ABOVE
        if(getColor() == Color.BLACK){
            p.SetValues(position.getRow() + 1, position.getColumm());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumm()] = true;
            }
            p.SetValues(position.getRow()+2, position.getColumm());
            Position p2 = new Position(position.getRow()+1,position.getColumm()); 
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumm()] = true;
            }
            p.SetValues(position.getRow()+1, position.getColumm()+1);
            if(getBoard().positionExists(p) && isThereAnyEnemyPiece(p)){
                mat[p.getRow()][p.getColumm()] = true;
            }
            p.SetValues(position.getRow()+1,position.getColumm()-1);
            if(getBoard().positionExists(p) && isThereAnyEnemyPiece(p)){
                mat[p.getRow()][p.getColumm()] = true;
            }
        }
        else{
            p.SetValues(position.getRow() - 1, position.getColumm());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumm()] = true;
            }
            p.SetValues(position.getRow() - 2, position.getColumm());
            Position p2 = new Position(position.getRow() - 1, position.getColumm());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[p.getRow()][p.getColumm()] = true;
            }
            p.SetValues(position.getRow() - 1, position.getColumm() + 1);
            if (getBoard().positionExists(p) && isThereAnyEnemyPiece(p)) {
                mat[p.getRow()][p.getColumm()] = true;
            }
            p.SetValues(position.getRow() - 1, position.getColumm() - 1);
            if (getBoard().positionExists(p) && isThereAnyEnemyPiece(p)) {
                mat[p.getRow()][p.getColumm()] = true;
            } 
        }
        return mat;
    }
    
}
