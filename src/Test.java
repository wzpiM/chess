import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.ImageIcon;


public class Test 
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run()
			{
				new Board();
			}
		});
	}
}

