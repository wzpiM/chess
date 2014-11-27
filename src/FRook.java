
public class FRook extends Chessman // Wieza
{

	protected FRook(Player player, Board chessboard) 
	{
		super(player, chessboard);
		
		if(player == Player.blackPlayer)
		{
			imageIcon = Images.BLACK_ROOK;
		}
		else
		{
			imageIcon = Images.WHITE_ROOK;
		}
	}

	@Override
	void designatePossibleMovements() 
	{
		possibleMovements.clear();
		int pos = this.getPosition();
		
		plnHelpFun(pos);
		polHelpFun(pos);
		wschHelpFun(pos);
		zachHelpFun(pos);
				
	}

	private void plnHelpFun(int pln)
	{
		while(pln-8 >= 0)
		{
			if(chessboard.buttons[pln-8].getChessman() == null)
			{
				this.addPossibleMovementToList(pln-8);
				pln = pln - 8;
			}
			else
			{
				
				if(chessboard.buttons[pln-8].getChessman().getPlayer() == this.owner)
				{
					break;
				}
				else
				{
					this.addPossibleMovementToList(pln-8);
					//pln = pln - 8;
					break;
				}
			}
		}
	}
	
	private void polHelpFun(int pol)
	{
		while(pol+8 <= 63)
		{
			if(chessboard.buttons[pol+8].getChessman() == null)
			{
				this.addPossibleMovementToList(pol+8);
				pol = pol + 8;
			}
			else
			{
				if(chessboard.buttons[pol+8].getChessman().getPlayer() == this.owner)
				{
					break;
				}
				else
				{
					this.addPossibleMovementToList(pol+8);
					//pol = pol + 8;
					break;
				}
			}
		}
	}
	
	private void wschHelpFun(int position)
	{
		if(chessboard.buttons[position].getChessman() == null)											//pole puste
		{
			if(position%8 == 0)
			{
				wschHelpFun(position+1);
			}
			else if(position%8 != 7)
			{
				this.addPossibleMovementToList(position);
				wschHelpFun(position+1);
			}
			else //position%8 == 7
			{
				this.addPossibleMovementToList(position);
			}
		}
		else
		{
			if(chessboard.buttons[position].getChessman().getPlayer() == this.getPlayer()) // nasza figura
			{
				if(position%8 == 0)
				{
					wschHelpFun(position+1);
				}
				else if(position%8 != 7)
				{
					if(this.getPosition() == position) // nasza figura ktora ruszamy
					{
						wschHelpFun(position+1);
					}
					else //inna
					{
						return;
					}
				}
				else //position%8 == 7
				{
					return;
				}
			}
			else																			//figura przeciwnika
			{
				this.addPossibleMovementToList(position);
				return;
			}
		}
	}

	private void zachHelpFun(int position)
	{
		if(chessboard.buttons[position].getChessman() == null)	
		{
			if(position%8 == 0)
			{
				this.addPossibleMovementToList(position);
				return;
				
			}
			else if(position%8 != 7)
			{
				this.addPossibleMovementToList(position);
				zachHelpFun(position-1);
			}
			else //position%8 == 7
			{
				zachHelpFun(position-1);
			}
		}
		else
		{
			if(chessboard.buttons[position].getChessman().getPlayer() == this.getPlayer()) // nasza figura
			{
				if(position%8 == 0)
				{
					return;
				}
				else if(position%8 != 7)
				{
					if(this.getPosition() == position) // nasza figura ktora ruszamy
					{
						zachHelpFun(position-1);
					}
					else //inna
					{
						return;
					}
				}
				else //position%8 == 7
				{
					zachHelpFun(position-1);
				}
			}
			else																			//figura przeciwnika
			{
				this.addPossibleMovementToList(position);
				return;
			}
		}
	}

	public String toString()
	{
		return "FRook, position "+this.getPosition();
	}
	

}
