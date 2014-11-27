
public class FQueen extends Chessman 
{

	protected FQueen(Player player, Board chessboard) 
	{
		super(player, chessboard);
		
		if(player == Player.blackPlayer)
		{
			imageIcon = Images.BLACK_QUEEN;
		}
		else
		{
			imageIcon = Images.WHITE_QUEEN;
		}
	}

	@Override
	void designatePossibleMovements() 
	{
		this.possibleMovements.clear();
		
		int pos = this.getPosition();
		
		plnZachHelpFun(pos);
		polZachHelpFun(pos);
		plnWschHelpFun(pos);
		polWschHelpFun(pos);
		
		plnHelpFun(pos);
		polHelpFun(pos);
		wschHelpFun(pos);
		zachHelpFun(pos);
		
	}

	private void plnZachHelpFun(int position)
	{
		if(chessboard.buttons[position].getChessman() == null)	
		{
			if(position >= 56 || position%8 == 7)
			{
				// to sie nigdy nie powinno zdarzyc
				System.out.println("FATAL ERROR !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");	
			}
			else if(position%8 == 0 || position <= 7)
			{
				this.addPossibleMovementToList(position);
				return;
			}
			else
			{
				this.addPossibleMovementToList(position);
				plnZachHelpFun(position-9);
			}
		}
		else
		{
			if(chessboard.buttons[position].getChessman().getPlayer() == this.getPlayer()) // nasza figura
			{
				
				if(position%8 == 0 || position <= 7)		//kolejnosc if-ow jest tutaj wazna !!!
				{
					return;
				}
				else if(position >= 56 || position%8 == 7)
				{
					plnZachHelpFun(position-9);	
				}
				else
				{
					if(this.getPosition() == position)
					{
						plnZachHelpFun(position-9);
					}
					else
					{
						return;
					}
				}
			}
			else	//figura przeciwnika
			{
				this.addPossibleMovementToList(position);
				return;
			}
		}
	
	}
	
	private void polZachHelpFun(int position)
	{
		if(chessboard.buttons[position].getChessman() == null)	
		{
			if(position <= 7 || position%8 == 7)
			{
				//to sie nigdy nie powinno zdarzyc
				System.out.println("FATAL ERROR !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			else if(position%8 == 0 || position >= 56)
			{
				this.addPossibleMovementToList(position);
				return;
			}
			else
			{
				this.addPossibleMovementToList(position);
				polZachHelpFun(position+7);
			}
		}
		else
		{
			if(chessboard.buttons[position].getChessman().getPlayer() == this.getPlayer()) // nasza figura
			{
				
				if(position%8 == 0 || position >= 56)			//kolejnosc if-ow jest tutaj wazna !!!
				{
					return;
				}
				else if(position <= 7 || position%8 == 7)
				{
					polZachHelpFun(position+7);
				}
				else
				{
					if(this.getPosition() == position)
					{
						polZachHelpFun(position+7);
					}
					else
					{
						return;
					}
				}
			}
			else	//figura przeciwnika
			{
				this.addPossibleMovementToList(position);
				return;
			}
		}
	
	}
	
	private void polWschHelpFun(int position)
	{
		if(chessboard.buttons[position].getChessman() == null)	
		{
			if(position >= 56 || position%8 == 7)
			{
				this.addPossibleMovementToList(position);
				return;
			}
			else if(position%8 == 0 || position <= 7)
			{
				//to sie nigdy nie powinno zdarzyc
				System.out.println("FATAL ERROR !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			
			}
			else
			{
				this.addPossibleMovementToList(position);
				polWschHelpFun(position+9);
			}
		}
		else
		{
			if(chessboard.buttons[position].getChessman().getPlayer() == this.getPlayer()) // nasza figura
			{
				if(position >= 56 || position%8 == 7)	//jesli jestesmy na brzegu pol/wsch kolejnosc if-ow jest tutaj wazna !!!
				{
					return;
				}
				else if(position%8 == 0 || position <= 7)	//jesli jestesmy na brzegu pln/zach
				{
					polWschHelpFun(position+9);
				}
				else
				{
					if(this.getPosition() == position)		//jesli  jestesmy w srodku i jest to nasza figura, ktora zaznaczylismy
					{
						polWschHelpFun(position+9);
					}
					else									//jesli  jestesmy w srodku i jest to nasza inna figura - koniec ruchu
					{
						return;
					}
				}
			}
			else	//figura przeciwnika
			{
				this.addPossibleMovementToList(position);
				return;
			}
		}
	}
		
	private void plnWschHelpFun(int position)
	{
		if(chessboard.buttons[position].getChessman() == null)	
		{
			if(position <= 7 || position%8 == 7)
			{
				this.addPossibleMovementToList(position);
				return;
			}
			else if(position%8 == 0 || position>= 56)
			{
				//to sie nigdy nie powinno zdarzyc
				System.out.println("FATAL ERROR !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
			else 
			{
				this.addPossibleMovementToList(position);
				plnWschHelpFun(position-7);
			}
		}
		else
		{
			if(chessboard.buttons[position].getChessman().getPlayer() == this.getPlayer()) // nasza figura
			{
				if(position <= 7 || position%8 == 7)			//kolejnosc if-ow jest tutaj wazna !!!
				{
					return;
				}
				else if(position%8 == 0 || position >= 56)
				{
					plnWschHelpFun(position-7);
				}
				else
				{
					if(this.getPosition() == position)
					{
						plnWschHelpFun(position-7);
					}
					else
					{
						return;
					}
				}
			}
			else //figura przeciwnika
			{
				this.addPossibleMovementToList(position);
				return;
			}
		}
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
		return "FQueen, position "+this.getPosition();
	}
	
}
