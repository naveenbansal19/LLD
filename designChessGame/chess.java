//this code is containing only skeleton of the chess game
import java.util.*;

package LLD.chessGame;

public class chess {
    ChessBoard chessBoard;
    Player[] player;
    Player currentPlayer;
    List<Move> moveList;
    GameStatus gameStatus;

    public boolean playerMove(CellPosition fromPosition,CellPosition toPosition,Piece piece);
    public boolean endGame();
    private void changeTurn();

}

public class Player{
    Account account;
    Color color;
    Time timeLeft;
}
public class Account{
    String username;
    String password;

    String name;
    String email;
    String phone;
}
public enum Color{
    WHITE,BLACk;
}
public class Time{
    int mins;
    int secs;
}

public enum gameStatus{
    ACTIVE,FORFEIT,PAUSED,BLACK_WIN,WHITE_WIN;
}

public class chessBoard{
    List<List<Cell>> board;

    public void resetBoard();
    public void updateBoard(Move move);
}

public class Cell{
    Color color;
    Piece piece;
    CellPosition cellPosition;
}
public class CellPosition{
    char ch;
    int i;
}

public class Move{
    Player player;
    Piece piece;
    Piece killedPiece; 
    CellPosition startPosition;
    CellPosition endPosition;
}

public abstract class Piece{
    Color color;  //black or white 
    public boolean move(CellPosition fromPosition, CellPositionb toPosition); //piece will obviously move from current position to destination
	public List<CellPosition> possibleMoves(CellPosition fromPosition);  //this API is for all possible positons we can reach from current position
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition); //check valid move or not
    
}
public class Bishop extends Piece{
    Color color;  //black or white 
    public boolean move(CellPosition fromPosition, CellPositionb toPosition); //piece will obviously move from current position to destination
	public List<CellPosition> possibleMoves(CellPosition fromPosition);  //this API is for all possible positons we can reach from current position
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition); //check valid move or not
}
public class Rook extends Piece{
    Color color;  //black or white 
    public boolean move(CellPosition fromPosition, CellPositionb toPosition); //piece will obviously move from current position to destination
	public List<CellPosition> possibleMoves(CellPosition fromPosition);  //this API is for all possible positons we can reach from current position
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition); //check valid move or not
}
public class Knight extends Piece{
    Color color;  //black or white 
    public boolean move(CellPosition fromPosition, CellPositionb toPosition); //piece will obviously move from current position to destination
	public List<CellPosition> possibleMoves(CellPosition fromPosition);  //this API is for all possible positons we can reach from current position
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition); //check valid move or not
}
public class Pawn extends Piece{
    Color color;  //black or white 
    public boolean move(CellPosition fromPosition, CellPositionb toPosition); //piece will obviously move from current position to destination
	public List<CellPosition> possibleMoves(CellPosition fromPosition);  //this API is for all possible positons we can reach from current position
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition); //check valid move or not
}
public class King extends Piece{
    Color color;  //black or white 
    public boolean move(CellPosition fromPosition, CellPositionb toPosition); //piece will obviously move from current position to destination
	public List<CellPosition> possibleMoves(CellPosition fromPosition);  //this API is for all possible positons we can reach from current position
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition); //check valid move or not
}

public class Queen extends Piece{
    Color color;  //black or white 
    public boolean move(CellPosition fromPosition, CellPositionb toPosition); //piece will obviously move from current position to destination
	public List<CellPosition> possibleMoves(CellPosition fromPosition);  //this API is for all possible positons we can reach from current position
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition); //check valid move or not
}
