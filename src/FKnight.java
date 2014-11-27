import java.util.Arrays;
import java.util.LinkedList;


public class FKnight extends Chessman
{

	protected FKnight(Player player, Board chessboard) 
	{
		super(player, chessboard);
		
		if(player == Player.blackPlayer)
		{
			imageIcon = Images.BLACK_KNIGHT;
		}
		else
		{
			imageIcon = Images.WHITE_KNIGHT;
		}
	}

	@Override
	void designatePossibleMovements() 
	{
		this.possibleMovements.clear();
		
		int pos = getPosition();
		
		if(pos >= 18 && pos <= 45 && pos %8 >= 2 && pos%8 <=5)
		{
			this.addPossibleMovementToList(pos-17);
			this.addPossibleMovementToList(pos-15);
			this.addPossibleMovementToList(pos-10);
			this.addPossibleMovementToList(pos-6);
			this.addPossibleMovementToList(pos+6);
			this.addPossibleMovementToList(pos+10);
			this.addPossibleMovementToList(pos+15);
			this.addPossibleMovementToList(pos+17);
		}
		else if(pos>=2 && pos <=5)
		{
			this.addPossibleMovementToList(pos+6);
			this.addPossibleMovementToList(pos+10);
			this.addPossibleMovementToList(pos+15);
			this.addPossibleMovementToList(pos+17);
			
		}
		else if(pos>=10 && pos<=13)
		{
			this.addPossibleMovementToList(pos-10);
			this.addPossibleMovementToList(pos-6);
			this.addPossibleMovementToList(pos+6);
			this.addPossibleMovementToList(pos+10);
			this.addPossibleMovementToList(pos+15);
			this.addPossibleMovementToList(pos+17);
			
		}
		else if(pos >=50 && pos <=53)
		{
			this.addPossibleMovementToList(pos-17);
			this.addPossibleMovementToList(pos-15);
			this.addPossibleMovementToList(pos-10);
			this.addPossibleMovementToList(pos-6);
			this.addPossibleMovementToList(pos+6);
			this.addPossibleMovementToList(pos+10);
			
		}
		else if(pos>=58 && pos <=61)
		{
			this.addPossibleMovementToList(pos-17);
			this.addPossibleMovementToList(pos-15);
			this.addPossibleMovementToList(pos-10);
			this.addPossibleMovementToList(pos-6);
			
		}
		else if(pos%8 == 0 && pos >=16 && pos <=40)
		{
			this.addPossibleMovementToList(pos-15);
			this.addPossibleMovementToList(pos-6);
			this.addPossibleMovementToList(pos+10);
			this.addPossibleMovementToList(pos+17);
			
		}
		else if(pos%8 == 1 && pos >=16 && pos <=41)
		{
			this.addPossibleMovementToList(pos-17);
			this.addPossibleMovementToList(pos-15);
			this.addPossibleMovementToList(pos-6);
			this.addPossibleMovementToList(pos+10);
			this.addPossibleMovementToList(pos+15);
			this.addPossibleMovementToList(pos+17);
			
		}
		else if(pos%8 == 6 && pos >=22 && pos <=46)
		{
			this.addPossibleMovementToList(pos-17);
			this.addPossibleMovementToList(pos-15);
			this.addPossibleMovementToList(pos-10);
			this.addPossibleMovementToList(pos+6);
			this.addPossibleMovementToList(pos+15);
			this.addPossibleMovementToList(pos+17);
			
		}
		else if(pos%8 ==7 && pos >=23 && pos <=47)
		{
			this.addPossibleMovementToList(pos-17);
			this.addPossibleMovementToList(pos-10);
			this.addPossibleMovementToList(pos+6);
			this.addPossibleMovementToList(pos+15);
			
		}
		else
		{
			if(pos>=48 && pos%8 != 0)
			{
				this.addPossibleMovementToList(pos-17);
			}
			
			if(pos>=48 && pos%8 != 7)
			{
				this.addPossibleMovementToList(pos-15);
			}
			
			if(pos>=14 && (pos%8 == 6 || pos%8 == 7))
			{
				this.addPossibleMovementToList(pos-10);
			}
			
			if(pos>=8 && (pos%8 == 0 || pos%8 == 1))
			{
				this.addPossibleMovementToList(pos-6);
			}
			
			if(pos <= 55 && (pos%8 == 6 || pos%8 == 7))
			{
				this.addPossibleMovementToList(pos+6);
			}
			
			if(pos <=49 && (pos%8 == 0 || pos%8 == 1))
			{
				this.addPossibleMovementToList(pos+10);
			}
			
			if(pos<=15 && pos%8 != 0)
			{
				this.addPossibleMovementToList(pos+15);
			}
			
			if(pos<=15 && pos%8 != 7 )
			{
				this.addPossibleMovementToList(pos+17);
			}
		}
		
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//		System.out.println("GRACZ: "+this.getPlayer());
//		System.out.println("FIGURA NA POZYCJI: "+this.getPosition()+", RUCHY: "+possibleMovements);
//		
		LinkedList<Integer> listToRemove = new LinkedList<Integer>();
		
		for(int i=0; i<possibleMovements.size(); i++)
		{
			if(this.chessboard.buttons[possibleMovements.get(i)].getChessman()!=null && this.chessboard.buttons[possibleMovements.get(i)].getChessman().getPlayer() == this.getPlayer() )
			{
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
		return "FKnight, position "+this.getPosition();
	}

	
	
}
