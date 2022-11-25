package chessGame;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import chessGame.pieces.King;
import chessGame.pieces.Pawn;
import chessGame.pieces.Rook;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChessMatch {
    private int turn;
    private Color currentPlayer;
    private Board board;
    private boolean check;
    private boolean checkMate;
    private List<Piece> piecesOnBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();
    
    public ChessMatch(){
        board = new Board(8,8);
        turn =1;
        currentPlayer = Color.WHITE;
        check = false;
        initialSetup();
    }
    
    //Only the GETTERS as this variable cannot be changed;
    public int getTurn(){
        return turn;
    }
    public Color getCurrentPlayer(){
        return currentPlayer;
    }
    public boolean getCheck(){
        return check;
    }
    public boolean getCheckMate(){
        return checkMate;
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
        if(testCheck(currentPlayer)){
            undoMove(source, target, capturedPiece);
            throw new chessGameException ("You can't put yourself in CHECK!");
        }
        check = testCheck(opponent(currentPlayer));
        if(testCheckMate(opponent(currentPlayer))){
            checkMate = true;
        }else{
            nextTurn();
        }
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
        ChessPiece p =(ChessPiece)board.removePiece(source);
        p.IncreaseMoveCount();
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        if(capturedPiece != null){
            piecesOnBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
        return capturedPiece;
    }
    
    private void undoMove(Position source, Position target, Piece capturedPiece){
        ChessPiece p = (ChessPiece)board.removePiece(target);
        p.DecreaseMoveCount();
        board.placePiece(p, source);
        if(capturedPiece != null){
            board.placePiece(capturedPiece, target);
            capturedPieces.remove(capturedPiece);
            piecesOnBoard.add(capturedPiece);
        }
    }
    
    public boolean[][] possibleMoves(ChessPosition source){
        Position position = source.toPositon();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }
    
    private ChessPiece king(Color color){
        List<Piece> list = piecesOnBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color ).collect(Collectors.toList());
        for(Piece p : list){
            if(p instanceof King){
                return (ChessPiece)p;
            }
        }
        throw new IllegalStateException ("FATAL ERROR [There is no "+color+" king on the board]");
    }
    
    private Color opponent(Color color){
        if(color == Color.WHITE){
            return Color.BLACK;
        }else{
            return Color.WHITE;
        }
    }
    
    private boolean testCheck(Color color){
        Position kingPosition = king(color).getChessPosition().toPositon();
        List<Piece> opponentPieces = piecesOnBoard.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).collect(Collectors.toList());
        for(Piece p : opponentPieces){
            boolean [][] mat = p.possibleMoves();
            if(mat[kingPosition.getRow()][kingPosition.getColumm()] ){
                return true;
            }
        }
        return false;
    }
    
    private boolean testCheckMate(Color color){
        if(!testCheck(color)){
            return false;
        }
        List<Piece> list = piecesOnBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
        for(Piece p : list){
            boolean[][] mat = p.possibleMoves();
            for(int i=0; i<board.getRows(); i++){
                for(int j=0; j<board.getColumms(); j++){
                    if(mat[i][j]){
                        Position source = ((ChessPiece)p).getChessPosition().toPositon();
                        Position target = new Position(i, j);
                        Piece capturedPiece = makeMove(source, target);
                        boolean testCheck = testCheck(color);
                        undoMove(source, target, capturedPiece);
                        if(!testCheck){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
    private void nextTurn(){
        turn ++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE; 
    }
    private void placeNewPiece(char columm, int row, ChessPiece piece){
        board.placePiece(piece,new ChessPosition(columm,  row).toPositon());
        piecesOnBoard.add(piece);
    }
    
    //
    public void initialSetup(){
        placeNewPiece('a',8, new Rook(Color.BLACK, board));
        
        placeNewPiece('d',8 ,new King(Color.BLACK, board));
        
        placeNewPiece('h',8, new Rook(Color.BLACK, board));
        
        placeNewPiece('h',7,new Pawn(Color.BLACK,board));
        placeNewPiece('g',7,new Pawn(Color.BLACK,board));
        placeNewPiece('f',7,new Pawn(Color.BLACK,board));
        placeNewPiece('e',7,new Pawn(Color.BLACK,board));
        placeNewPiece('d',7,new Pawn(Color.BLACK,board));
        placeNewPiece('c',7,new Pawn(Color.BLACK,board));
        placeNewPiece('b',7,new Pawn(Color.BLACK,board));
        placeNewPiece('a',7,new Pawn(Color.BLACK,board));

        
        
        
        placeNewPiece('a',1, new Rook(Color.WHITE, board));
        
        placeNewPiece('d',1, new King (Color.WHITE,board));
        
        placeNewPiece('h',1, new Rook(Color.WHITE, board));
        
        placeNewPiece('a',2,new Pawn(Color.WHITE, board));
        placeNewPiece('b',2,new Pawn(Color.WHITE, board));
        placeNewPiece('c',2,new Pawn(Color.WHITE, board));
        placeNewPiece('d',2,new Pawn(Color.WHITE, board));
        placeNewPiece('e',2,new Pawn(Color.WHITE, board));
        placeNewPiece('f',2,new Pawn(Color.WHITE, board));
        placeNewPiece('g',2,new Pawn(Color.WHITE, board));
        placeNewPiece('h',2,new Pawn(Color.WHITE, board));
    }
}
