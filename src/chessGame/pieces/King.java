
package chessGame.pieces;

import boardGame.Board;
import boardGame.Position;
import chessGame.ChessMatch;
import chessGame.ChessPiece;
import chessGame.Color;

public class King extends ChessPiece{
    private ChessMatch chessMatch;

    public King(Color color, Board board, ChessMatch chessMatch) {
        super(color, board);
        this.chessMatch = chessMatch;
    }
    
    @Override
    public String toString(){
        return "K";
    }

    private boolean testCastling(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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
        
        //<-> SpecialMove Castling
        if(getMoveCount() == 0 && !chessMatch.getCheck()){
            //<-> SpecialMove small Castling 
            Position positionRookH = new Position(position.getRow(), position.getColumm() + 3);
            if(testCastling(positionRookH)){
                Position positionI = new Position(position.getRow(), position.getColumm()+2);
                Position positionII = new Position(position.getRow(), position.getColumm()+1);
                if(getBoard().piece(positionI) == null && getBoard().piece(positionII) == null){
                    mat[position.getRow()][position.getColumm()+2] = true;
                }
            }
            //<-> SpecialMove Big Castling
            Position positionRookA = new Position(position.getRow(), position.getColumm() - 4);
            if(testCastling(positionRookA)){
                Position positionI = new Position(position.getRow(), position.getColumm() - 3);
                Position positionII = new Position(position.getRow(), position.getColumm() - 2);
                Position positionIII = new Position(position.getRow(), position.getColumm() - 1);
                if(getBoard().piece(positionI) == null && getBoard().piece(positionII) == null &&getBoard().piece(positionIII) == null){
                    mat[position.getRow()][position.getColumm() - 2] = true;
                }
            }
        }
        
        return mat;
    }
}
