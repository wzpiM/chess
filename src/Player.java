import java.util.LinkedList;


public class Player 
{
	String name;
	private LinkedList<Integer> allPosibleMovementsOfThisPlayer = new LinkedList<Integer>();
	
	
	private Player(String name)
	{
		this.name = name;
	}
	
	public static final Player whitePlayer = new Player("White Player");
	public static final Player blackPlayer = new Player("Black Player");
	
	public LinkedList<Integer> getAllPossibleMovementsOfThisPlayer()
	{
		return allPosibleMovementsOfThisPlayer;
	}
	
	public String toString()
	{
		return this == Player.whitePlayer ? "   , WHITE PLAYER " : "   , BLACK PLAYER";	
	}
	
	
}
