import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;


class Images 
{
	
	private Images()
	{
		
	}
	
	//public static final ImageIcon LIGHT_FIELD = new ImageIcon("src\\resources\\jasne_tlo.png");
	//public static final ImageIcon DARK_FIELD = new ImageIcon("src\\resources\\ciemne_tlo.png");
	
	public final static Color SELECTED_FIELD = new Color(34,177,76);
	public final static Color MOVEMENT_PATH_FIELD = new Color(128,255,128);
	public final static Color ELIMINATE_FIELD = new Color(255,0,0);
	
	public final static Color DARK_FIELD = new Color(143,49,3);
	public final static Color LIGHT_FIELD = new Color(244,169,66);
	
	
	// black chessemen
	

	public static final ImageIcon BLACK_ROOK = changeSize (new ImageIcon("src\\resources\\black_rook.gif"));
	
	public static final ImageIcon BLACK_KNIGHT = changeSize(new ImageIcon("src\\resources\\black_knight.gif"));
	
	public static final ImageIcon BLACK_BISHOP = changeSize(new ImageIcon("src\\resources\\black_bishop.gif"));
	
	public static final ImageIcon BLACK_KING = changeSize(new ImageIcon("src\\resources\\black_king.gif"));
	
	public static final ImageIcon BLACK_QUEEN = changeSize(new ImageIcon("src\\resources\\black_queen.gif"));
	
	public static final ImageIcon BLACK_PAWN = changeSize(new ImageIcon("src\\resources\\black_pawn.gif"));
	
	
	// white chessmen
	
	public static final ImageIcon WHITE_ROOK = changeSize(new ImageIcon("src\\resources\\white_rook.gif"));
	
	public static final ImageIcon WHITE_KNIGHT = changeSize(new ImageIcon("src\\resources\\white_knight.gif"));
	
	public static final ImageIcon WHITE_BISHOP = changeSize(new ImageIcon("src\\resources\\white_bishop.gif"));
	
	public static final ImageIcon WHITE_KING = changeSize(new ImageIcon("src\\resources\\white_king.gif"));
	
	public static final ImageIcon WHITE_QUEEN = changeSize(new ImageIcon("src\\resources\\white_queen.gif"));
	
	public static final ImageIcon WHITE_PAWN = changeSize(new ImageIcon("src\\resources\\white_pawn.gif"));
	
	private static ImageIcon changeSize(ImageIcon imageicon)
	{
		 Image img = imageicon.getImage();  
		 Image newimg = img.getScaledInstance(79,79,4); 
		 return imageicon = new ImageIcon( newimg );
	}
	
	
	
	
	
	
//	public static final ImageIcon LIGHT_FIELD_BLACK_ROOK = changeSize (new ImageIcon("src\\resources\\jasne_tlo_black_rook.png"));
//	public static final ImageIcon DARK_FIELD_BLACK_ROOK = changeSize (new ImageIcon("src\\resources\\ciemne_tlo_black_rook.png"));
//	
//	public static final ImageIcon LIGHT_FIELD_BLACK_KNIGHT = changeSize(new ImageIcon("src\\resources\\jasne_tlo_black_knight.png"));
//	public static final ImageIcon DARK_FIELD_BLACK_KNIGHT = changeSize(new ImageIcon("src\\resources\\ciemne_tlo_black_knight.png"));
//	
//	public static final ImageIcon LIGHT_FIELD_BLACK_BISHOP = changeSize(new ImageIcon("src\\resources\\jasne_tlo_black_bishop.png"));
//	public static final ImageIcon DARK_FIELD_BLACK_BISHOP = changeSize(new ImageIcon("src\\resources\\ciemne_tlo_black_bishop.png"));
//	
//	public static final ImageIcon LIGHT_FIELD_BLACK_KING = changeSize(new ImageIcon("src\\resources\\jasne_tlo_black_king.png"));
//	public static final ImageIcon DARK_FIELD_BLACK_KING = changeSize(new ImageIcon("src\\resources\\ciemne_tlo_black_king.png"));
//	
//	public static final ImageIcon LIGHT_FIELD_BLACK_QUEEN = changeSize(new ImageIcon("src\\resources\\jasne_tlo_black_queen.png"));
//	public static final ImageIcon DARK_FIELD_BLACK_QUEEN = changeSize(new ImageIcon("src\\resources\\ciemne_tlo_black_queen.png"));
//	
//	public static final ImageIcon LIGHT_FIELD_BLACK_PAWN = changeSize(new ImageIcon("src\\resources\\jasne_tlo_black_pawn.png"));
//	public static final ImageIcon DARK_FIELD_BLACK_PAWN = changeSize(new ImageIcon("src\\resources\\ciemne_tlo_black_pawn.png"));
//	
//	
//	// white chessmen
//	
//	public static final ImageIcon LIGHT_FIELD_WHITE_ROOK = changeSize(new ImageIcon("src\\resources\\jasne_tlo_white_rook.png"));
//	public static final ImageIcon DARK_FIELD_WHITE_ROOK = changeSize(new ImageIcon("src\\resources\\ciemne_tlo_white_rook.png"));
//
//	public static final ImageIcon LIGHT_FIELD_WHITE_KNIGHT = changeSize(new ImageIcon("src\\resources\\jasne_tlo_white_knight.png"));
//	public static final ImageIcon DARK_FIELD_WHITE_KNIGHT = changeSize(new ImageIcon("src\\resources\\ciemne_tlo_white_knight.png"));
//
//	public static final ImageIcon LIGHT_FIELD_WHITE_BISHOP = changeSize(new ImageIcon("src\\resources\\jasne_tlo_white_bishop.png"));
//	public static final ImageIcon DARK_FIELD_WHITE_BISHOP = changeSize(new ImageIcon("src\\resources\\ciemne_tlo_white_bishop.png"));
//
//	public static final ImageIcon LIGHT_FIELD_WHITE_KING = changeSize(new ImageIcon("src\\resources\\jasne_tlo_white_king.png"));
//	public static final ImageIcon DARK_FIELD_WHITE_KING = changeSize(new ImageIcon("src\\resources\\ciemne_tlo_white_king.png"));
//
//	public static final ImageIcon LIGHT_FIELD_WHITE_QUEEN = changeSize(new ImageIcon("src\\resources\\jasne_tlo_white_queen.png"));
//	public static final ImageIcon DARK_FIELD_WHITE_QUEEN = changeSize(new ImageIcon("src\\resources\\ciemne_tlo_white_queen.png"));
//
//	public static final ImageIcon LIGHT_FIELD_WHITE_PAWN = changeSize(new ImageIcon("src\\resources\\jasne_tlo_white_pawn.png"));
//	public static final ImageIcon DARK_FIELD_WHITE_PAWN = changeSize(new ImageIcon("src\\resources\\ciemne_tlo_white_pawn.png"));
	
	//selected chessmen
	
//	public static final ImageIcon SELECTED_WHITE_ROOK = changeSize(new ImageIcon("src\\resources\\selected_white_rook.png"));
//	public static final ImageIcon SELECTED_WHITE_KNIGHT = changeSize(new ImageIcon("src\\resources\\selected_white_knight.png"));
//	public static final ImageIcon SELECTED_WHITE_BISHOP = changeSize(new ImageIcon("src\\resources\\selected_white_bishop.png"));
//	public static final ImageIcon SELECTED_WHITE_KING = changeSize(new ImageIcon("src\\resources\\selected_white_king.png"));
//	public static final ImageIcon SELECTED_WHITE_QUEEN = changeSize(new ImageIcon("src\\resources\\selected_white_queen.png"));
//	public static final ImageIcon SELECTED_WHITE_PAWN = changeSize(new ImageIcon("src\\resources\\selected_white_pawn.png"));
//	
//	public static final ImageIcon SELECTED_BLACK_ROOK = changeSize(new ImageIcon("src\\resources\\selected_black_rook.png"));
//	public static final ImageIcon SELECTED_BLACK_KNIGHT = changeSize(new ImageIcon("src\\resources\\selected_black_knight.png"));
//	public static final ImageIcon SELECTED_BLACK_BISHOP = changeSize(new ImageIcon("src\\resources\\selected_black_bishop.png"));
//	public static final ImageIcon SELECTED_BLACK_KING = changeSize(new ImageIcon("src\\resources\\selected_black_king.png"));
//	public static final ImageIcon SELECTED_BLACK_QUEEN = changeSize(new ImageIcon("src\\resources\\selected_black_queen.png"));
//	public static final ImageIcon SELECTED_BLACK_PAWN = changeSize(new ImageIcon("src\\resources\\selected_black_pawn.png"));

	
	

}
