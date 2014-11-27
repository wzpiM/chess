import java.util.LinkedList;


public class FBishop extends Chessman
{

	protected FBishop(Player player, Board chessboard) 
	{
		super(player, chessboard);
		
		if(player == Player.blackPlayer)
		{
			imageIcon = Images.BLACK_BISHOP;
		}
		else
		{
			imageIcon = Images.WHITE_BISHOP;
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
	
	
	
	
	public String toString()
	{
		return "FBishop, position "+this.getPosition();
	}

//	@Override
//	boolean whetherItWillBeCheckAfterThisMove(int firstKingsPosition, int secondKingsPosition) 
//	{
//		boolean flag = false;
//		LinkedList<Integer> originalListOfMoves = this.possibleMovements;
//		
//		possibleMovements = new LinkedList<Integer>();
//		
//		// "przemalowanie planszy" - przesuniecie krola zalozonym ruchem na dana pozycje
//		this.chessboard.buttons[secondKingsPosition].setChessman(this.chessboard.buttons[firstKingsPosition].getChessman());
//		this.chessboard.buttons[firstKingsPosition].setChessman(null);
//		
//		
//		designatePossibleMovements();
//		
//		flag = this.possibleMovements.contains(secondKingsPosition);
//		
//		this.possibleMovements = originalListOfMoves;
//		
//		return flag;
//	}

	
	
}
