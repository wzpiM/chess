
public class FPawn extends Chessman // Pion
{

	
	public String toString()
	{
		return "FPawn, position "+this.getPosition();
	}
	
	
	protected FPawn(Player player, Board chessboard) 
	{
		super(player, chessboard);
		
		if(player == Player.blackPlayer)
		{
			imageIcon = Images.BLACK_PAWN;
		}
		else
		{
			imageIcon = Images.WHITE_PAWN;
		}
		
		
	}

	

	@Override
	void designatePossibleMovements() 
	{
		
		possibleMovements.clear();
		
			if(this.owner == Player.whitePlayer)
			{
				
				if(this.position >=0 && this.position <=7)
				{
					System.out.println("TUTAJ TRZEBA ZMIENIC FIGURE BIALA !!!!!!!!!!!! ");
					// ....
				}
				// OGARNAC JESZCZE POLA 0,7 !!!!!!!!!!! przetestowac
				else if(this.position%8 == 0 )												//mozliwy ruch w prawo skos
				{
					if(this.chessboard.buttons[position-7].getChessman() != null &&
							this.chessboard.buttons[position-7].getChessman().getPlayer() == Player.blackPlayer && 
							this.chessboard.buttons[position-7].getChessman().getImageIcon() != Images.BLACK_KING)
					{
						this.addPossibleMovementToList(position-7);
					}
				}
				else if(this.position%8 == 7)											//mozliwy ruch w lewo skos
				{
					if(this.chessboard.buttons[position-9].getChessman() != null &&
							this.chessboard.buttons[position-9].getChessman().getPlayer() == Player.blackPlayer && 
							this.chessboard.buttons[position-9].getChessman().getImageIcon() != Images.BLACK_KING)
					{
						this.addPossibleMovementToList(position-9);
					}
				}
				else
				{
					if(this.chessboard.buttons[position-7].getChessman() != null &&
							this.chessboard.buttons[position-7].getChessman().getPlayer() == Player.blackPlayer && 
							this.chessboard.buttons[position-7].getChessman().getImageIcon() != Images.BLACK_KING)
					{
						this.addPossibleMovementToList(position-7);
					}
					if(this.chessboard.buttons[position-9].getChessman() != null &&
							this.chessboard.buttons[position-9].getChessman().getPlayer() == Player.blackPlayer && 
							this.chessboard.buttons[position-9].getChessman().getImageIcon() != Images.BLACK_KING)
					{
						this.addPossibleMovementToList(position-9);
					}
				}
				

				if(this.position - 8 >= 0)
				{
					if(this.chessboard.buttons[position-8].getChessman() == null)
					{
						this.addPossibleMovementToList(position-8);
						if(firstMoveDone == false)				// if pawn didnt do its first move
						{
							if(this.chessboard.buttons[position-16].getChessman() == null)
							{
								this.addPossibleMovementToList(position-16);
							}
						}
					}

				}
								
						
				
				
				// JESZCZE DODAC MOZLIWOSCI ZBICIA FIGURY PRZECIWNIKA ORAZ BRAK MOZLIWOSCI RUCHU, JESLI JEST TO KROL(TO DRUGIE PRZEMYSLEC)
			}
			else // jestesmy czarnym playerem
			{
				if(this.position >=56 && this.position <=63)
				{
					System.out.println("TUTAJ TRZEBA ZMIENIC FIGURE CZARNA !!!!!!!!!!!! ");
					// ....
					
				}
				else if(this.position%8 == 0 )												//mozliwy ruch w prawo skos
				{
					if(this.chessboard.buttons[position+9].getChessman() != null &&
							this.chessboard.buttons[position+9].getChessman().getPlayer() == Player.whitePlayer && 
							this.chessboard.buttons[position+9].getChessman().getImageIcon() != Images.WHITE_KING)
					{
						this.addPossibleMovementToList(position+9);
					}
				}
				else if(this.position%8 == 7)											//mozliwy ruch w lewo skos
				{
					if(this.chessboard.buttons[position+7].getChessman() != null &&
							this.chessboard.buttons[position+7].getChessman().getPlayer() == Player.whitePlayer && 
							this.chessboard.buttons[position+7].getChessman().getImageIcon() != Images.WHITE_KING)
					{
						this.addPossibleMovementToList(position+7);
					}
					
					
				}
				else
				{
					if(this.chessboard.buttons[position+7].getChessman() != null &&
							this.chessboard.buttons[position+7].getChessman().getPlayer() == Player.whitePlayer && 
							this.chessboard.buttons[position+7].getChessman().getImageIcon() != Images.WHITE_KING)
					{
						this.addPossibleMovementToList(position+7);
					}
					if(this.chessboard.buttons[position+9].getChessman() != null &&
							this.chessboard.buttons[position+9].getChessman().getPlayer() == Player.whitePlayer && 
							this.chessboard.buttons[position+9].getChessman().getImageIcon() != Images.WHITE_KING)
					{
						this.addPossibleMovementToList(position+9);
					}
					
					// test
					
//					if(this.chessboard.buttons[position+9].getChessman() == null)
//					{
//						this.addPossibleMovementToList(position+9);
//					}
					
					// /test
					
				}
				
				if(this.position + 8 <= 63)
				{
					if(this.chessboard.buttons[position+8].getChessman() == null)
					{
						this.addPossibleMovementToList(position+8);
						if(firstMoveDone == false)				// if pawn didnt do its first move
						{
							if(this.chessboard.buttons[position+16].getChessman() == null)
							{
								this.addPossibleMovementToList(position+16);
							}
						}
					}
				}
				
				// ...
			
		}

	}
	
	
	
}
