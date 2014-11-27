import java.awt.Color;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;


 abstract class Chessman 
{

	LinkedList<Integer> possibleMovements = new LinkedList<Integer>();
	boolean isSelected = false;
	ImageIcon imageIcon;
	Player owner;
	int position = -1;
	Board chessboard;
	protected boolean firstMoveDone = false;
	
	public boolean getFirstMoveDone()
	{
		return firstMoveDone;
	}
	
	public void firstMoveJustDone()				//necessary to use if pawn was used for the first time
	{
		firstMoveDone = true;
	}
	
	protected Chessman(Player player, Board chessboard)
	{
		owner = player;
		this.chessboard = chessboard;
	}
	
	public Chessman(Chessman other)
	{
		for(int i=0; i<other.possibleMovements.size(); i++)
		{
			possibleMovements.add(other.possibleMovements.get(i));
		}
		
		imageIcon = other.imageIcon;
		owner = other.owner;
		position = other.position;
		chessboard = other.chessboard;
	}
	
	//abstract void designatePossibleMovements();
	
	public void clear()
	{
		imageIcon = null;
		owner = null;
		chessboard = null;
		position = -1;
	}
	
	boolean getIsSelected()
	{
		return isSelected;
	}
	
	void setIsSelected(boolean isSelected)
	{
		this.isSelected = isSelected;
	}
	
	ImageIcon getImageIcon()
	{
		return imageIcon;
	}
	
	void setImageIcon(ImageIcon image)
	{
		this.imageIcon = image;
	}
	
	LinkedList<Integer> getPossibleMovements()
	{
		return possibleMovements;
	}
	
	Player getPlayer()
	{
		return owner;
	}
	
	public int getPosition()
	{
		return position;
	}
	
	public void setPosition(int newPosition) throws IndexOutOfBoundsException // moze jakis wyjatek??
	{
		if(newPosition < -1 || newPosition >= 64) throw new IndexOutOfBoundsException();
		else
		{
			position = newPosition;
		}
	}
	
	abstract void designatePossibleMovements();
	
	boolean whetherItWillBeCheckAfterThisMove(int firstKingsPosition, int secondKingsPosition)
	{
		boolean flag = false;
		LinkedList<Integer> originalListOfMoves = this.possibleMovements;
		
		possibleMovements = new LinkedList<Integer>();
		
		Chessman tempChessman1 = this.chessboard.buttons[firstKingsPosition].getChessman();
		Chessman tempChessman2 = this.chessboard.buttons[secondKingsPosition].getChessman();
		
		
		// "przemalowanie planszy" - przesuniecie krola zalozonym ruchem na dana pozycje
		this.chessboard.buttons[secondKingsPosition].setChessman(this.chessboard.buttons[firstKingsPosition].getChessman());
		this.chessboard.buttons[firstKingsPosition].setChessman(null);
		
		

		designatePossibleMovements();
		
		flag = this.possibleMovements.contains(secondKingsPosition);
		
		this.possibleMovements = originalListOfMoves;
		this.chessboard.buttons[firstKingsPosition].setChessman(tempChessman1);
		this.chessboard.buttons[secondKingsPosition].setChessman(tempChessman2);
		
		return flag;
	}
	
	void addPossibleMovementToList(int index)
	{
		possibleMovements.add(index);
	}
}

