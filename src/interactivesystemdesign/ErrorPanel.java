package interactivesystemdesign;

import java.awt.*;
import javax.swing.*;

public class ErrorPanel extends JPanel {// this class is to show the error message
	JPanel errorPanel;
	public static String errorText = "";
	
	public ErrorPanel() {
		setSize(504,30);
	}
	
	public ErrorPanel(String s) {
		setSize(504,30);
		errorText = s;
	}
	
	public void paint(Graphics g) {
		if(errorText.equals("")) {
			g.setColor(new Color(238,238,238));
			g.fillRect(0, 0, 504, 30);
		}else {
			g.setColor(new Color( 249, 126, 121 ));
			g.fillRect(0, 0, 504, 30);
			g.setColor(Color.gray);
			g.drawRect(0, 0, 504, 30);
			g.setColor(Color.black);
			g.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 16));
			g.drawString(errorText, 10, 20);
		}
	}
}
