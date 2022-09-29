
package program;

import chessGame.ChessMatch;
import chessGame.ChessPiece;
import chessGame.ChessPosition;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        ChessMatch chess = new ChessMatch();
        
        
        //Testing
        while(true){
           UI.printBoard(chess.getPieces()); 
            System.out.print("\nSource: ");
            ChessPosition source = UI.readChessPosition(sc);
            System.out.print("\nTarget: ");
            ChessPosition target = UI.readChessPosition(sc);
            ChessPiece capturedPiece = chess.performChessMove(source, target);
        }
        
        
    }
    
}
