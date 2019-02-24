package interactivesystemdesign;

import java.awt.*;
import javax.swing.*;

public class Badge2 extends JPanel {
	//this class is for drawing our badge area.
	public static int xCenter;
	public static int yCenter;		
	public static int badgeWidth = 504;
	public static int badgeHeight = 304;
	public static boolean ifError;
	
	
	
	public Badge2(){
        setSize(badgeWidth,badgeHeight);
        GuiBadge.width = 300;
        GuiBadge.height = 200;
        GuiBadge.fontstyle = "PLAIN";
        GuiBadge.backgroundcolor = "White";
        GuiBadge.shape = "";
        GuiBadge.color = "Black";
        GuiBadge.shape = "oval";
        GuiBadge.name = "Enter Your Name";
        GuiBadge.fontsize = 30;
        setVisible(true);
	}
	
	public Badge2(String x) {//this constructor could input shape and fontstyle
		if(x.equals("oval") || x.equals("rectangle") || x.equals("rounded")) {
			GuiBadge.shape = x;
		}else if(x.equals("PLAIN") || x.equals("BOLD") || x.equals("ITALIC") || x.equals("BOLDITALIC")) {
			GuiBadge.fontstyle = x;
		}
	}
	
	public Badge2(int type, String x) {//this constructor could input color and name
		if(type == 0) {
			GuiBadge.backgroundcolor = x;
		}else if(type == 1) {
			GuiBadge.color = x;
		}else if(type == 2) {
			GuiBadge.name = x;
		}
	}
	
	public Badge2(int type,int x) {//this constructor could input the numbers(width, height, fontsize)
		if(type == 0) {
			GuiBadge.width = x;
		}else if (type == 1) {
			GuiBadge.height = x;
		}else if (type == 2) {
			GuiBadge.fontsize = x;
		}
		
	}
	

	public boolean checkShapeSize(String s, Graphics g) {// this method is for checking if the shape fit the string
		FontMetrics fm = g.getFontMetrics();
		
		int StringHeight = 2 * GuiBadge.fontsize + fm.getAscent();
		//check if the oval width fits font width
		if(GuiBadge.shape.equals("oval")) {
			//those values are to calculate the width of the oval when it on special height.
			double x =  (1 - Math.pow(GuiBadge.fontsize + fm.getDescent(), 2) / Math.pow(GuiBadge.height/2, 2)) * Math.pow(GuiBadge.width/2, 2);
			int lastLineOvalWidth = (int) (Math.sqrt(x) * 2);
			double y = (1 - Math.pow(GuiBadge.fontsize + fm.getAscent(), 2) / Math.pow(GuiBadge.height/2, 2)) * Math.pow(GuiBadge.width/2, 2);
			int firstLineOvalWidth =(int) (Math.sqrt(y) * 2);
			
			if(s.equals("My Name is")) {
				if(fm.stringWidth(s) > GuiBadge.width) {
					
					ErrorPanel.errorText = "The text width will bigger than shape width!";
					return false;
				}
			}else if (s.equals("Hello")){
				if(fm.stringWidth(s) > firstLineOvalWidth) {
					
					ErrorPanel.errorText = "The text width will bigger than shape width!";
					return false;
				}
			}else{
				if(fm.stringWidth(s) > lastLineOvalWidth) {
					
					ErrorPanel.errorText = "The text width will bigger than shape width!";
					return false;
				}
			}
			
		}else {//check if the rectangle and rounded width fit font width
			if(fm.stringWidth(s) > GuiBadge.width) {
				ErrorPanel.errorText = "The text width will bigger than shape width!";
				return false;
			}
		}
		
		//check if the shape height fits font width
		if(StringHeight > GuiBadge.height) {
			ErrorPanel.errorText = "The text height will bigger than shape height!";
			return false;
		}
		return true;
	}
	
	public int drawCenteredString(String s, int w, int h, Graphics g) {//this method is for drawing string in the center.
	    
	    Font myFont = new Font("Arial", Font.PLAIN, GuiBadge.fontsize);	
	    	if (GuiBadge.fontstyle.equals("PLAIN")) {
	    		myFont = new Font("SansSerif", Font.PLAIN, GuiBadge.fontsize);	    
	    	}
	    	else if (GuiBadge.fontstyle.equals("BOLD")) {
	    		myFont = new Font("SansSerif", Font.BOLD, GuiBadge.fontsize);
	    	}
	    	else if (GuiBadge.fontstyle.equals("ITALIC")) {
	    		myFont = new Font("SansSerif", Font.ITALIC, GuiBadge.fontsize);
	    	}
	    	else if (GuiBadge.fontstyle.equals("BOLDITALIC")) {
	    		myFont = new Font("SansSerif", Font.BOLD + Font.ITALIC, GuiBadge.fontsize);
	    	}
		g.setFont(myFont);
		
		FontMetrics fm = g.getFontMetrics();
	    int x = (w - fm.stringWidth(s)) / 2;
	    int y = (fm.getAscent() + (h - fm.getHeight()) / 2);   
	    g.drawString(s, x, y);
	    
	    return fm.stringWidth(s);
	}

	public void paint(Graphics g) {//draw badge
		
		Graphics2D g2d = ( Graphics2D ) g;
		if (GuiBadge.backgroundcolor.equals("Black")) {
    		g.setColor( Color.black );	 
        }
        else if (GuiBadge.backgroundcolor.equals("Blue")) {
        	g.setColor( Color.blue );	 
        }
        else if (GuiBadge.backgroundcolor.equals("Cyan")) {
        	g.setColor( Color.cyan );	 
        }
        else if (GuiBadge.backgroundcolor.equals("Dark Gray")) {
        	g.setColor( Color.darkGray);	 
        }
        else if (GuiBadge.backgroundcolor.equals("Gray")) {
        	g.setColor( Color.gray);	 
        }
        else if (GuiBadge.backgroundcolor.equals("Green")) {
        	g.setColor( Color.green);	 
        }
        else if (GuiBadge.backgroundcolor.equals("Light Gray")) {
        	g.setColor( Color.lightGray);	 
        }
        else if (GuiBadge.backgroundcolor.equals("Magenta")) {
        	g.setColor( Color.magenta);	 
        }
        else if (GuiBadge.backgroundcolor.equals("Orange")) {
        	g.setColor( Color.orange);	 
        }
        else if (GuiBadge.backgroundcolor.equals("Pink")) {
        	g.setColor( Color.pink);	 
        }
        else if (GuiBadge.backgroundcolor.equals("Red")) {
        	g.setColor( Color.red);	 
        }
        else if (GuiBadge.backgroundcolor.equals("White")) {
        	g.setColor( Color.white);	 
        }
        else if (GuiBadge.backgroundcolor.equals("Yellow")) {
        	g.setColor( Color.yellow);	 
        }else{
        	g.setColor( Color.white);
        }
		
			g.fillRect(0, 0, badgeWidth, badgeHeight);
		
			
    	
		if (GuiBadge.color.equals("Black")) {
    		g.setColor( Color.black );	 
        }
        else if (GuiBadge.color.equals("Blue")) {
        	g.setColor( Color.blue );	 
        }
        else if (GuiBadge.color.equals("Cyan")) {
        	g.setColor( Color.cyan );	 
        }
        else if (GuiBadge.color.equals("Dark Gray")) {
        	g.setColor( Color.darkGray);	 
        }
        else if (GuiBadge.color.equals("Gray")) {
        	g.setColor( Color.gray);	 
        }
        else if (GuiBadge.color.equals("Green")) {
        	g.setColor( Color.green);	 
        }
        else if (GuiBadge.color.equals("Light Gray")) {
        	g.setColor( Color.lightGray);	 
        }
        else if (GuiBadge.color.equals("Magenta")) {
        	g.setColor( Color.magenta);	 
        }
        else if (GuiBadge.color.equals("Orange")) {
        	g.setColor( Color.orange);	 
        }
        else if (GuiBadge.color.equals("Pink")) {
        	g.setColor( Color.pink);	 
        }
        else if (GuiBadge.color.equals("Red")) {
        	g.setColor( Color.red);	 
        }
        else if (GuiBadge.color.equals("White")) {
        	g.setColor( Color.white);	 
        }
        else if (GuiBadge.color.equals("Yellow")) {
        	g.setColor( Color.yellow);	 
        }else{
        	g.setColor( Color.black);
        }
		
			xCenter = badgeWidth/2 - GuiBadge.width/2;
			yCenter = badgeHeight/2 - GuiBadge.height/2;	
		
    	
		if (GuiBadge.shape.equals("oval")) {
    		g.drawOval(xCenter, yCenter, GuiBadge.width, GuiBadge.height);          
    	}
    	else if (GuiBadge.shape.equals("rectangle")) {
    		g.drawRect(xCenter, yCenter, GuiBadge.width, GuiBadge.height);        
    	}
    	else if (GuiBadge.shape.equals("rounded")) {
    		g.drawRoundRect(xCenter, yCenter, GuiBadge.width, GuiBadge.height, 15, 15);
    	}else if (GuiBadge.shape.equals("")) {
    		
    	}
		
		
        drawCenteredString("Hello", badgeWidth, badgeHeight-(GuiBadge.fontsize * 2), g);
    	drawCenteredString("My Name is", badgeWidth, badgeHeight, g);
    	drawCenteredString(GuiBadge.name, badgeWidth, badgeHeight+(GuiBadge.fontsize * 2), g);
    	
    	checkShapeSize("Hello",g);
    	boolean temple1 = checkShapeSize("My Name is",g);
    	boolean temple2 = checkShapeSize(GuiBadge.name,g);
    	if(temple1 && temple2) {//the checkShapeSize() return false when the shape dosen't fit string
    		
    		ifError = true;  // ifError = true means no error in shape and string
    		ErrorPanel.errorText = "";
    		
    		//check if there other error
    		if (GuiBadge.color.equals(GuiBadge.backgroundcolor) ) {
        		ErrorPanel.errorText = "Your fontground color is the same as background color!";
            }else if(GuiBadge.height > 300) {
            	ErrorPanel.errorText = "Please input the height number < 300!";
            }else if(GuiBadge.width > 500) {
            	ErrorPanel.errorText = "Please input the width number < 500!";
            }else if (GuiBadge.fontsize > 90) {
            	ErrorPanel.errorText = "Please input the font size < 90!";
            }else if(GuiBadge.name.length() > 20) {
            	ErrorPanel.errorText = "The name must less than 20 letters!";
            }else if(!GuiBadge.noNumberText.equals("") && !GuiBadge.noNumberText.equals("1-300") && !GuiBadge.noNumberText.equals("1-500")) {
            	ErrorPanel.errorText = "Please only input the positive number!";
            }
    		GuiBadge.drawErrorPanel.repaint();
    	}else {
    		ifError = false;
    		GuiBadge.drawErrorPanel.repaint();
    	}
    	
    	g.setColor(Color.gray);
    	g2d.setStroke( new BasicStroke( 2.0f ) );
    	g.drawRect( 0, 0, badgeWidth, badgeHeight); 
	}
}