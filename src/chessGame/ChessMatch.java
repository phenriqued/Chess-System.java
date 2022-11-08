package chessGame;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import chessGame.pieces.King;
import chessGame.pieces.Rook;

public class ChessMatch {
    private int turn;
    private Color currentPlayer;
    private Board board;
    
    public ChessMatch(){
        board = new Board(8,8);
        turn =1;
        currentPlayer = Color.WHITE;
        initialSetup();
    }
    
    //Only the GETTERS as this variable cannot be changed;
    public int getTurn(){
        return turn;
    }
    public Color getCurrentPlayer(){
        return currentPlayer;
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
    
    //Responsible for moving a piece and "eat" some enemy piece.
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPositon();
        Position target = targetPosition.toPositon();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece)capturedPiece;
    }
    private void validateSourcePosition(Position position){
        if(!board.thereIsAPiece(position)){
            throw new chessGameException("There is no piece on source position!");
        }
        if(currentPlayer != ((ChessPiece)board.piece(position)).getColor() ){
            throw new chessGameException("The Chosen piece is not your.");
        }
        if(!board.piece(position).isThereAnyPossibleMove()){
            throw new chessGameException("There is no possible moves for the chosen piece.");
        }
    }
    private void validateTargetPosition(Position source, Position target){
        if(!board.piece(source).possibleMove(target)){
            throw new chessGameException("The chosen piece can't move to target position.") ;
        }
    }
    
    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }
    
    public boolean[][] possibleMoves(ChessPosition source){
        Position position = source.toPositon();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }
    
    private void nextTurn(){
        turn ++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE; 
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
