
package boardGame;


public class Board {
    private int rows;
    private int columms;
    private Piece[][] pieces;
    
    public Board(int rows, int columms ){
        if(rows < 1 || columms < 1){
            throw new boardGameException("[ERROR] Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columms = columms;
        pieces = new Piece[rows][columms];
    }

    public int getRows() {
        return rows;
    }
    public int getColumms() {
        return columms;
    }
    
    //Retuurn a place the piece on the board
    public Piece piece(int row, int columm){
        if(!positionExists(row,columm)){
            throw new boardGameException("[ERROR] Position not on the board.");
        }
        return pieces[row][columm];
    }
    
    //Returns a position for a part.
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new boardGameException("[ERROR] Position not on the board.");
        }
        return pieces[position.getRow()][position.getColumm()];
    }
    
    //Place the piece on the board.
    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new boardGameException("Theres is already a piece on position" + position);
        }
        pieces[position.getRow()][position.getColumm()] = piece;
        piece.position = position;
    }
    
    //Responsible for knowing if the position exists
    private boolean positionExists(int row, int columm){
        //responsible for testing if it is inside the board.
        return row >= 0 && row < rows && columm >= 0 && columm < columms;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumm());
    }
    
    //Responsible for returning itself to a value in position, using the "piece(position)" method
    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new boardGameException("Position not on the board.");
        }
        return piece(position) != null;
    }
}
