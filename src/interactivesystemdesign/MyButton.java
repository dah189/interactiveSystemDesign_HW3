package interactivesystemdesign;

import java.awt.*;
import javax.swing.*;

public class MyButton extends JButton {//this class is to draw the shape on the buttons
	public String buttonType;
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		if(buttonType.equals("oval")) {
			g.drawOval(8,6,29,18);
		}else if(buttonType.equals("rectangle")) {
			g.drawRect(8,6,29,18);
		}else if(buttonType.equals("rounded")) {
			g.drawRoundRect(8,6,29,18,5,5);
		}
	}
}
