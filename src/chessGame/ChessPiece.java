
package chessGame;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;

public abstract class ChessPiece extends Piece{
    private Color color;
    private int moveCount;

    public ChessPiece(Color color, Board board) {
        super(board);
        this.color = color;
    }
    public Color getColor(){
        return color;
    }
    public int getMoveCount(){
        return moveCount;
    }
    
    public void IncreaseMoveCount(){
        moveCount++;
    }
    
    public void DecreaseMoveCount(){
        moveCount--;
    }
    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }
    
   protected boolean isThereAnyEnemyPiece(Position position){
       ChessPiece p = (ChessPiece)getBoard().piece(position);
       return p != null && p.getColor() != color;
   } 

}
