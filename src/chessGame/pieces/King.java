
package chessGame.pieces;

import boardGame.Board;
import boardGame.Position;
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


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumms()];
        Position p = new Position(0,0); 
        
        //ABOVE
        p.SetValues(position.getRow()-1, position.getColumm());
        if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumm()]=true;
        }
        if(getBoard().positionExists(p) && isThereAnyEnemyPiece(p)){
            mat[p.getRow()][p.getColumm()]=true;
        }
        
        //LOW
        p.SetValues(position.getRow()+1, position.getColumm());
        if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumm()]=true;
        }
        if(getBoard().positionExists(p) && isThereAnyEnemyPiece(p)){
            mat[p.getRow()][p.getColumm()]=true;
        }
        
        //LEFT
        p.SetValues(position.getRow(), position.getColumm()-1);
        if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumm()]=true;
        }
        if(getBoard().positionExists(p) && isThereAnyEnemyPiece(p)){
            mat[p.getRow()][p.getColumm()]=true;
        }
        
        //RIGTH
        p.SetValues(position.getRow(), position.getColumm()+1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        if (getBoard().positionExists(p) && isThereAnyEnemyPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }

        //N.W
        p.SetValues(position.getRow()-1, position.getColumm()-1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        if (getBoard().positionExists(p) && isThereAnyEnemyPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        //N.E
        p.SetValues(position.getRow()+1, position.getColumm()-1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        if (getBoard().positionExists(p) && isThereAnyEnemyPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        
        //S.W
        p.SetValues(position.getRow()-1, position.getColumm()+1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        if (getBoard().positionExists(p) && isThereAnyEnemyPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        //S.E
        p.SetValues(position.getRow()+1, position.getColumm()+1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        if (getBoard().positionExists(p) && isThereAnyEnemyPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        
        return mat;
    }
}
