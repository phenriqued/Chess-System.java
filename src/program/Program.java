
package program;

import chessGame.ChessMatch;

public class Program {

    public static void main(String[] args) {
        
        ChessMatch chess = new ChessMatch();
        UI.printBoard(chess.getPieces());
        
    }
    
}
