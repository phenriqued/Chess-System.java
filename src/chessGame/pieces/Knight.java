
package chessGame.pieces;

import boardGame.Board;
import boardGame.Position;
import chessGame.ChessPiece;
import chessGame.Color;

public class Knight extends ChessPiece{

    public Knight(Color color, Board board) {
        super(color, board);
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumms()];
        Position p = new Position(0,0);
        
        p.SetValues(position.getRow()-2, position.getColumm()+1);
        if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumm()]=true;
        }
        if(getBoard().positionExists(p) && isThereAnyEnemyPiece(p)){
            mat[p.getRow()][p.getColumm()]=true;
        }

        p.SetValues(position.getRow()-2, position.getColumm()-1);
        if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumm()]=true;
        }
        if(getBoard().positionExists(p) && isThereAnyEnemyPiece(p)){
            mat[p.getRow()][p.getColumm()]=true;
        }

        p.SetValues(position.getRow()+2, position.getColumm()+1);
        if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat[p.getRow()][p.getColumm()]=true;
        }
        if(getBoard().positionExists(p) && isThereAnyEnemyPiece(p)){
            mat[p.getRow()][p.getColumm()]=true;
        }

        p.SetValues(position.getRow()+2, position.getColumm()-1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        if (getBoard().positionExists(p) && isThereAnyEnemyPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }

        p.SetValues(position.getRow()-1, position.getColumm()+2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        if (getBoard().positionExists(p) && isThereAnyEnemyPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }

        p.SetValues(position.getRow()+1, position.getColumm()+2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        if (getBoard().positionExists(p) && isThereAnyEnemyPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }

        p.SetValues(position.getRow()-1, position.getColumm()-2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        if (getBoard().positionExists(p) && isThereAnyEnemyPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }

        p.SetValues(position.getRow()+1, position.getColumm()-2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        if (getBoard().positionExists(p) && isThereAnyEnemyPiece(p)) {
            mat[p.getRow()][p.getColumm()] = true;
        }
        
        return mat;
    }
    
}
