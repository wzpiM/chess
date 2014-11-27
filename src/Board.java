import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Board extends JFrame implements ActionListener
{
	//which player has his turn
	private Player currentPlayer = Player.whitePlayer;
	
	// is checkmate?
	private boolean isCheckmate = false;
	
	//help buttons
	private FieldButton helpButton1 = null;
	private FieldButton helpButton2 = null;
	
	
	private LinkedList<Integer> helpListOfMovementFields = new LinkedList<Integer>();
	
	
	private Icon helpIcon;
	
	Player whiteP = Player.whitePlayer;
	Player blackP = Player.blackPlayer;
	
	LinkedList<Chessman> whiteChessmenList = new LinkedList<Chessman>();
	LinkedList<Chessman> blackChessmenList = new LinkedList<Chessman>();
	
	FieldButton[] buttons = new FieldButton[64];
	
	public Board()
	{
		super("Chess @ Grzegorz Mikitowicz");
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640,640);
		
		setLocation(50,50);
		setLayout(new GridLayout(8,8));
		
	
		
		for(int i=0; i<64; i++)
		{
			buttons[i] = new FieldButton();
			buttons[i].setPosition(i);
			add(buttons[i]);
		}
		
		blackChessmenList.add(new FRook(Player.blackPlayer, this));
		blackChessmenList.add(new FKnight(Player.blackPlayer, this));
		blackChessmenList.add(new FBishop(Player.blackPlayer, this));
		blackChessmenList.add(new FQueen(Player.blackPlayer, this));
		blackChessmenList.add(new FKing(Player.blackPlayer, this));
		blackChessmenList.add(new FBishop(Player.blackPlayer, this));
		blackChessmenList.add(new FKnight(Player.blackPlayer, this));
		blackChessmenList.add(new FRook(Player.blackPlayer, this));

		for(int i=0; i<8; i++)
		{
			whiteChessmenList.add(new FPawn(Player.whitePlayer, this));
		}
		
		whiteChessmenList.add(new FRook(Player.whitePlayer, this));
		whiteChessmenList.add(new FKnight(Player.whitePlayer, this));
		whiteChessmenList.add(new FBishop(Player.whitePlayer, this));
		whiteChessmenList.add(new FQueen(Player.whitePlayer, this));
		whiteChessmenList.add(new FKing(Player.whitePlayer, this));
		whiteChessmenList.add(new FBishop(Player.whitePlayer, this));
		whiteChessmenList.add(new FKnight(Player.whitePlayer, this));
		whiteChessmenList.add(new FRook(Player.whitePlayer, this));
		
		for(int i=0; i<8; i++)
		{
			blackChessmenList.add(new FPawn(Player.blackPlayer, this));
		}
		
		for(int i=0; i<64; i++)
		{
			if(i%16<8)
			{
				if(i%2 == 0)
				{				
					buttons[i].setBackground(Images.LIGHT_FIELD);	
					buttons[i].setFieldNaturalColor(Images.LIGHT_FIELD);
				}
				else
				{
					buttons[i].setBackground(Images.DARK_FIELD);
					buttons[i].setFieldNaturalColor(Images.DARK_FIELD);
				}
			}
			else
			{
				if(i%2 == 0)
				{
					buttons[i].setBackground(Images.DARK_FIELD);
					buttons[i].setFieldNaturalColor(Images.DARK_FIELD);
				}
				else
				{
					buttons[i].setBackground(Images.LIGHT_FIELD);
					buttons[i].setFieldNaturalColor(Images.LIGHT_FIELD);
				}
			}
		}		
		
		for(int i=0; i<16; i++)
		{
			buttons[i].setChessman(blackChessmenList.get(i));
			buttons[i].getChessman().setPosition(i);
		}
		
		for(int i=48; i<64; i++)
		{
			buttons[i].setChessman(whiteChessmenList.get(i-48));
			buttons[i].getChessman().setPosition(i);
		}

		
		for(int i=0; i<64; i++)
		{
			buttons[i].addActionListener(this);
		}
		
		
		setAllPossibleMovementsOfWhitePlayer();
		setAllPossibleMovementsOfBlackPlayer();
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) 
	{

		Object source = event.getSource();
		FieldButton selectedButton = (FieldButton) source; 
		
		if(helpButton1 == null && selectedButton.getChessman() != null && selectedButton.getChessman().getPlayer() == currentPlayer) //wczesniej nie zaznaczono zadnego pola
		{
			//System.out.println("JEDEN");
			helpButton1 = selectedButton;
				
			for(int i=0; i<helpButton1.getChessman().getPossibleMovements().size(); i++)
			{
				helpListOfMovementFields.add(helpButton1.getChessman().getPossibleMovements().get(i));
				buttons[helpButton1.getChessman().getPossibleMovements().get(i)].setBackground(Images.MOVEMENT_PATH_FIELD);
			}
			
			helpButton1.setBackground(Images.SELECTED_FIELD);
		
		}
		else if(selectedButton == helpButton1)					// drugi raz klikamy ta sama figure
		{
			if(selectedButton.getChessman() == null)
			{
				return;
			}
			
			//System.out.println("DWA");
			for(int i=0; i<helpListOfMovementFields.size(); i++)
			{
				buttons[helpListOfMovementFields.get(i)].restoreNaturalColor();
			}
				
			helpListOfMovementFields.clear();
			helpButton1.restoreNaturalColor();
			helpButton1 = null;
			
		} 
		else if(helpButton1 != null && helpButton1.getChessman().getPossibleMovements().contains(selectedButton.getPosition()))
		{
			//System.out.println("TRZY");
			selectedButton.setChessman(helpButton1.getChessman());
			selectedButton.getChessman().setPosition(selectedButton.getPosition());
			selectedButton.getChessman().firstMoveJustDone();
				
				
			
			for(int i=0; i<helpListOfMovementFields.size(); i++)
			{
				buttons[helpListOfMovementFields.get(i)].restoreNaturalColor();
			}
				
			helpButton1.setChessman(null);
				
			helpListOfMovementFields.clear();
			helpButton1.restoreNaturalColor();
			
			helpButton1 = null;
				
			for(int i=0; i<whiteChessmenList.size(); i++)
			{
				whiteChessmenList.get(i).designatePossibleMovements();
			}
			
			for(int i=0; i< blackChessmenList.size(); i++)
			{
				blackChessmenList.get(i).designatePossibleMovements();
			}
			
			//selectedButton.getChessman().designatePossibleMovements();
			
			if(currentPlayer == Player.whitePlayer)
			{
				currentPlayer = Player.blackPlayer;
			}
			else
			{
				currentPlayer = Player.whitePlayer;
			}
			
			printTheSituationOnTheChessboard();
			
		}
		else if(helpButton1 != null && (helpButton1 != selectedButton) && (whiteChessmenList.contains(selectedButton.getChessman())))
		{
			//System.out.println("CZTERY");
	
			helpButton1.restoreNaturalColor();
				
				
			for(int i=0; i<helpListOfMovementFields.size(); i++)
			{
				buttons[helpListOfMovementFields.get(i)].restoreNaturalColor();

			}
				
			helpListOfMovementFields.clear();			
			helpButton1 = selectedButton;
				
			for(int i=0; i<helpButton1.getChessman().getPossibleMovements().size(); i++)
			{
				helpListOfMovementFields.add(helpButton1.getChessman().getPossibleMovements().get(i));
				buttons[helpButton1.getChessman().getPossibleMovements().get(i)].setBackground(Images.MOVEMENT_PATH_FIELD);
			}
				helpButton1.setBackground(Images.SELECTED_FIELD);
		}
		
	
		
	}
	
	public void setAllPossibleMovementsOfWhitePlayer()
	{
		for(int i=0; i<whiteChessmenList.size(); i++)
		{
			if(whiteChessmenList.get(i) != null)
			{
				whiteChessmenList.get(i).designatePossibleMovements();
			}
			else
			{
				whiteChessmenList.remove(i);
			}
		}
		
//		for(int i=0; i<8; i++)
//		{
//			System.out.println(whiteChessmenList.get(i).getPossibleMovements());
//		}
	}
	
	public void setAllPossibleMovementsOfBlackPlayer()
	{
		for(int i=0; i<blackChessmenList.size(); i++)
		{
			if(blackChessmenList.get(i)!= null)
			{
				blackChessmenList.get(i).designatePossibleMovements();
			}
			else
			{
				blackChessmenList.remove(i);
			}
		}
		
//		for(int i=0; i<blackChessmenList.size(); i++)
//		{
//			System.out.println(blackChessmenList.get(i).getPossibleMovements());
//		}
	}
	
	public void printTheSituationOnTheChessboard()
	{
//		System.out.println("###################################");
//		
//		for(int i=0; i< this.buttons.length; i++)
//		{
//			if(buttons[i].getChessman()!= null)
//			{
//				System.out.println(buttons[i].getChessman().toString()+buttons[i].getChessman().owner);
//			}
//		}
	}
	
	public boolean isOpponentTeamContainingMoveAtPosition(Player playerOwner, int position)
	{
		
		if(playerOwner == Player.whitePlayer)
		{
			for(int i=0; i<blackChessmenList.size(); i++)
			{
				if(blackChessmenList.get(i).possibleMovements.contains(position))
				{
					return true;
				}
			}
		}
		else // opponent == Player.blackPlayer
		{
			for(int i=0; i<whiteChessmenList.size(); i++)
			{
				if(whiteChessmenList.get(i).possibleMovements.contains(position))
				{
					return true;
				}
			}	
		}
		return false;
	}
	
	
}
