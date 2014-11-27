import java.awt.Color;

import javax.swing.JButton;


public class FieldButton extends JButton 
{
	//private static final long serialVersionUID = 1L;
	private Chessman chessman = null;							//chessman that this field actually is occupied by
	private int position = -1;
	
	private Color fieldNaturalColor = Color.black;
	
	
	public int getPosition()
	{
		return position;
	}
	
	public void setPosition(int p)
	{
		position = p;
	}
	
	
	
	public void setFieldNaturalColor(Color c)
	{
		//System.out.println("1111111111");
		fieldNaturalColor = c;
		//System.out.println("2222222222");
	}
	
	public Color getNaturalColor()
	{
		//System.out.println("3333333");
		return fieldNaturalColor;
		
	}
	
	public void restoreNaturalColor()
	{
		//System.out.println("444444444444");
		setBackground(fieldNaturalColor);
		//System.out.println("55555555555");
	}
	
	public FieldButton()
	{
		
	}
	
	public FieldButton(Chessman ch)
	{
		chessman = ch;
		this.setIcon(ch.getImageIcon());
		
	}
	
	public Chessman getChessman()
	{
		return chessman;
	}
	
	public void setChessman(Chessman ch)
	{
		chessman = ch;
		if(ch != null)
		{
			this.setIcon(ch.getImageIcon());
		}
		else
		{
			this.setIcon(null);
		}
	}
	
	
}
