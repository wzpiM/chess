import java.util.LinkedList;


public class FKing extends Chessman // Krol
{

	protected FKing(Player player, Board chessboard) 
	{
		super(player, chessboard);
		
		if(player == Player.blackPlayer)
		{
			imageIcon = Images.BLACK_KING;
		}
		else
		{
			imageIcon = Images.WHITE_KING;
		}
	}

	@Override
	void designatePossibleMovements() 
	{
		int pos = this.getPosition();
		
		this.possibleMovements.clear();
		
		if(pos == 0)
		{
			this.addPossibleMovementToList(pos+1);
			this.addPossibleMovementToList(pos+8);
			this.addPossibleMovementToList(pos+9);
		}
		else if(pos == 7)
		{
			this.addPossibleMovementToList(pos-1);
			this.addPossibleMovementToList(pos+7);
			this.addPossibleMovementToList(pos+8);
		}
		else if(pos == 56)
		{
			this.addPossibleMovementToList(pos-8);
			this.addPossibleMovementToList(pos-7);
			this.addPossibleMovementToList(pos+1);
		}
		else if(pos == 63)
		{
			this.addPossibleMovementToList(pos-9);
			this.addPossibleMovementToList(pos-8);
			this.addPossibleMovementToList(pos-1);
		}
		else if(pos%8==0)
		{
			this.addPossibleMovementToList(pos-8);
			this.addPossibleMovementToList(pos+8);
			this.addPossibleMovementToList(pos-7);
			this.addPossibleMovementToList(pos+1);
			this.addPossibleMovementToList(pos+9);
		}
		else if(pos<=7)
		{
			this.addPossibleMovementToList(pos-1);
			this.addPossibleMovementToList(pos+1);
			this.addPossibleMovementToList(pos+7);
			this.addPossibleMovementToList(pos+8);
			this.addPossibleMovementToList(pos+9);
		}
		else if(pos%8==7)
		{
			this.addPossibleMovementToList(pos-8);
			this.addPossibleMovementToList(pos-9);
			this.addPossibleMovementToList(pos-1);
			this.addPossibleMovementToList(pos+7);
			this.addPossibleMovementToList(pos+8);
		}
		else if(pos>=55)
		{
			this.addPossibleMovementToList(pos-9);
			this.addPossibleMovementToList(pos-8);
			this.addPossibleMovementToList(pos-7);
			this.addPossibleMovementToList(pos-1);
			this.addPossibleMovementToList(pos+1);
		}
		
		LinkedList<Integer> listToRemove = new LinkedList<Integer>();
		
		System.out.println("ilosc mozliwych ruchow krola: "+this.possibleMovements.size()+this.getPlayer());
		
		for(int i=0; i<possibleMovements.size(); i++)
		{
			
			if(this.chessboard.buttons[possibleMovements.get(i)].getChessman()!=null)
			{
				System.out.println("PIERWSZY IF ....." + this.getPlayer());
				if(this.chessboard.buttons[possibleMovements.get(i)].getChessman().getPlayer() != this.getPlayer())
				{
					System.out.println("DRUGI IF ...."+this.getPlayer());
					
					boolean flag = false;
					
					if(this.getPlayer() == Player.whitePlayer) // przechodzimy po liscie figur czarnego playera
					{
					
						for(int j=0; j<this.chessboard.blackChessmenList.size(); j++)
						{
							if(this.chessboard.blackChessmenList.get(j).whetherItWillBeCheckAfterThisMove(this.getPosition(), this.possibleMovements.get(i)) == true)
							{
								flag = true;
							}
						}
					}
					else // Player.blackPlayer
					{
						
						for(int j=0; j<this.chessboard.whiteChessmenList.size();j++)
						{
							if(this.chessboard.whiteChessmenList.get(j).whetherItWillBeCheckAfterThisMove(this.getPosition(), this.possibleMovements.get(i)) == true)
							{
								flag = true;
							}
						}
					}
					
					if(flag == true)
					{
						listToRemove.add(possibleMovements.get(i));
					}
				}
				
			}
			else if(this.chessboard.buttons[possibleMovements.get(i)].getChessman()!=null && (this.chessboard.buttons[possibleMovements.get(i)].getChessman().getPlayer() == this.getPlayer())
					|| (this.chessboard.isOpponentTeamContainingMoveAtPosition(this.owner, possibleMovements.get(i))))
			{
				System.out.println("dodaje do usuniecia pozycje numer: "+possibleMovements.get(i));
				listToRemove.add(possibleMovements.get(i));
			}
			
		}
		
		for(int i=0; i<listToRemove.size();i++)
		{
			possibleMovements.remove(listToRemove.get(i));
		}
		
		
	}

	public String toString()
	{
		return "FKing, position "+this.getPosition();
	}

}
