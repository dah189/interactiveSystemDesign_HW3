package interactivesystemdesign;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class GuiBadge implements ActionListener , DocumentListener {

	JPanel totalGUI = new JPanel();
	JPanel p;
	public static ErrorPanel drawErrorPanel;
	Badge2 drawBadge;
	JLabel redLabel;
    JButton submit, fontR, fontB, fontI, fontBI;
    MyButton shapeOval, shapeRect, shapeRound;
    JButton colorButtons[], bgcolorButtons[];
    JTextField nameIn, fontsizeIn, widthSizeIn, heightSizeIn, errorIn;
    Color typeColor[] = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow};
    String iColor[] = {"Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
    JComboBox<String> colorChoice, colorChoice2;
    public static String noNumberText = "";
    final JPanel panel = new JPanel();
    
    
	public static String name;
	public static String shape = "";
	public static String color = "";
	public static String backgroundcolor = " ";
	public static int width = 0;
	public static int height = 0;
	public static int fontsize;
	public static String fontstyle;
	public static String font;
	
	
	public GuiBadge() { 
		super();
		JFrame frame = new JFrame("Badge");
		Container con = frame.getContentPane(); 
		frame.setBounds(500,100,900,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				drawBadge.requestFocus();
			}
		});																								
		con.add(createContentPane());
		con.repaint();
		frame.setVisible(true);
		frame.validate();
		frame.setResizable(false);
		
	}
	
	
	public JPanel createContentPane() {	
        totalGUI.setLayout(null);
        
        // Creation of a Panel to contain the title labels
        p = new JPanel();
        p.setLayout(null);
        p.setLocation(5, 0);
        p.setSize(900, 700);
        p.setBackground(new Color(238, 238, 238));
        totalGUI.add(p);
       
        redLabel = new JLabel("Design Your Badge");
        redLabel.setLocation(310, 0);
        redLabel.setSize(600, 200);
        redLabel.setFont(new Font("Arial", Font.BOLD, 30));
        redLabel.setHorizontalTextPosition(0);
        redLabel.setForeground(Color.black);
        p.add(redLabel);

        redLabel = new JLabel("Font Design:");
        redLabel.setLocation(50, 60);
        redLabel.setSize(200, 200);
        redLabel.setFont(new Font("Arial", Font.BOLD, 18));
        redLabel.setHorizontalTextPosition(0);
        redLabel.setForeground(Color.black);
        p.add(redLabel);
        
        nameIn=new JTextField("Enter Your Name"); 
        nameIn.setBounds(50, 180, 195, 30);  
        nameIn.getDocument().addDocumentListener(this);
        nameIn.addFocusListener(new JTextFieldHintListener(nameIn, "Enter Your Name"));
        nameIn.addActionListener(this);
        p.add(nameIn);
        
        redLabel = new JLabel("Style:");
        redLabel.setLocation(50, 125);
        redLabel.setSize(200, 200);
        redLabel.setFont(new Font("Arial", Font.BOLD, 13));
        redLabel.setHorizontalTextPosition(0);
        redLabel.setForeground(Color.black);
        p.add(redLabel);

        fontR=new JButton("R");
        fontR.addActionListener(this);
        fontR.setBounds(50, 240, 45, 30);
        fontR.setFont(new Font("Arial", Font.PLAIN, 12));
        fontR.setBackground(new Color(222, 222, 222));
        p.add(fontR);
        
        fontB=new JButton("B");
        fontB.addActionListener(this);
        fontB.setBounds(95, 240, 45, 30);
        fontB.setFont(new Font("Arial", Font.BOLD, 12));
        fontB.setBackground(new Color(222, 222, 222));
        p.add(fontB);
        
        fontI=new JButton("I");
        fontI.addActionListener(this);
        fontI.setBounds(140, 240, 45, 30);
//        fontI.setBackground(Color.red);
        fontI.setFont(new Font("Arial", Font.ITALIC, 12));
        fontI.setBackground(new Color(222, 222, 222));
        p.add(fontI);
        
        fontBI=new JButton("BI");
        fontBI.addActionListener(this);
        fontBI.setBounds(185, 240, 45, 30);
        fontBI.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 12));
        fontBI.setBackground(new Color(222, 222, 222));
        p.add(fontBI);
        
        redLabel = new JLabel("Size:");
        redLabel.setLocation(50, 195);
        redLabel.setSize(200, 200);
        redLabel.setFont(new Font("Arial", Font.BOLD, 13));
        redLabel.setHorizontalTextPosition(0);
        redLabel.setForeground(Color.black);
        p.add(redLabel);
        
        fontsizeIn=new JTextField("");  
        fontsizeIn.setBounds(90, 282, 45, 30);
        fontsizeIn.getDocument().addDocumentListener(this);
        fontsizeIn.addFocusListener(new JTextFieldHintListener(fontsizeIn, "30"));
        fontsizeIn.addActionListener(this);
        p.add(fontsizeIn);
        
        redLabel = new JLabel("Shape Design:");
        redLabel.setLocation(50, 250);
        redLabel.setSize(200, 200);
        redLabel.setFont(new Font("Arial", Font.BOLD, 18));
        redLabel.setHorizontalTextPosition(0);
        redLabel.setForeground(Color.black);
        p.add(redLabel);
        
        shapeOval = new MyButton();
        shapeOval.addActionListener(this);
        shapeOval.setBounds(50, 370, 45, 30);
        shapeOval.buttonType = "oval";
        shapeOval.setBackground(new Color(222, 222, 222));
        shapeOval.setToolTipText("Oval");
        p.add(shapeOval);
        
        shapeRect = new MyButton();
        shapeRect.addActionListener(this);
        shapeRect.setBounds(95, 370, 45, 30);
        shapeRect.buttonType = "rectangle";
        shapeRect.setBackground(new Color(222, 222, 222));
        shapeRect.setToolTipText("Rectangle");
        p.add(shapeRect);
        
        shapeRound = new MyButton();
        shapeRound.addActionListener(this);
        shapeRound.setBounds(140, 370, 45, 30);
        shapeRound.setBackground(new Color(222, 222, 222));
        shapeRound.buttonType = "rounded";
        shapeRound.setToolTipText("Rounded Rectangle");
        p.add(shapeRound);
            
        redLabel = new JLabel("Width:");
        redLabel.setLocation(50, 328);
        redLabel.setSize(200, 200);
        redLabel.setFont(new Font("Arial", Font.BOLD, 13));
        redLabel.setHorizontalTextPosition(0);
        redLabel.setForeground(Color.black);
        p.add(redLabel);
        
        widthSizeIn=new JTextField("");  
        widthSizeIn.setBounds(95, 413, 45, 30);  
        widthSizeIn.getDocument().addDocumentListener(this);
        widthSizeIn.addFocusListener(new JTextFieldHintListener(widthSizeIn, "1-500"));
        widthSizeIn.addActionListener(this);
        p.add(widthSizeIn);
       
        
        redLabel = new JLabel("Height:");
        redLabel.setLocation(150, 328);
        redLabel.setSize(200, 200);
        redLabel.setFont(new Font("Arial", Font.BOLD, 13));
        redLabel.setHorizontalTextPosition(0);
        redLabel.setForeground(Color.black);
        p.add(redLabel);
        
        heightSizeIn=new JTextField("");  
        heightSizeIn.setBounds(200, 413, 45, 30);    
        heightSizeIn.getDocument().addDocumentListener(this);
        heightSizeIn.addFocusListener(new JTextFieldHintListener(heightSizeIn, "1-300"));
        heightSizeIn.addActionListener(this);
        p.add(heightSizeIn);
           
        redLabel = new JLabel("Color Scheme:");
        redLabel.setLocation(50, 380);
        redLabel.setSize(200, 200);
        redLabel.setFont(new Font("Arial", Font.BOLD, 18));
        redLabel.setHorizontalTextPosition(0);
        redLabel.setForeground(Color.black);
        p.add(redLabel);
        
        redLabel = new JLabel("Border and Font:");
        redLabel.setLocation(50, 405);
        redLabel.setSize(200, 200);
        redLabel.setFont(new Font("Arial", Font.BOLD, 13));
        redLabel.setHorizontalTextPosition(0);
        redLabel.setForeground(Color.black);
        p.add(redLabel);
        
      //set 13 color buttons.
        colorButtons = new JButton[typeColor.length];
        for(int i = 0; i < colorButtons.length; i++) {
        	colorButtons[i] = new JButton("");
        	colorButtons[i].addActionListener(this);
        	if(i<7) {
        		colorButtons[i].setBounds(50 + i * 26, 520, 20, 20);
        	}else {
        		colorButtons[i].setBounds(50 + (i - 7 )* 26, 546, 20, 20);
        	}
        	colorButtons[i].setBackground(typeColor[i]);
            colorButtons[i].setToolTipText(""+ iColor[i]);
        	p.add(colorButtons[i]);
        }
        
        redLabel = new JLabel("Background:");
        redLabel.setLocation(50, 485);
        redLabel.setSize(200, 200);
        redLabel.setFont(new Font("Arial", Font.BOLD, 13));
        redLabel.setHorizontalTextPosition(0);
        redLabel.setForeground(Color.black);
        p.add(redLabel);
        
        //set 13 color buttons.
        bgcolorButtons = new JButton[typeColor.length];
        for(int i = 0; i < bgcolorButtons.length; i++) {
        	bgcolorButtons[i] = new JButton("");
        	bgcolorButtons[i].addActionListener(this);
        	if(i<7) {
        		bgcolorButtons[i].setBounds(50 + i * 26, 600, 20, 20);
        	}else {
        		bgcolorButtons[i].setBounds(50 + (i - 7 )* 26, 626, 20, 20);
        	}
        	bgcolorButtons[i].setBackground(typeColor[i]);
            bgcolorButtons[i].setToolTipText(""+ iColor[i]);
        	p.add(bgcolorButtons[i]);
        }
             
        drawBadge = new Badge2();
        drawBadge.setLayout(null);
        drawBadge.setLocation(320, 160);
        drawBadge.setOpaque(true);
        p.add(drawBadge);
        
        drawErrorPanel = new ErrorPanel("");
        drawErrorPanel.setLayout(null);
        drawErrorPanel.setLocation(320, 500);
	    p.add(drawErrorPanel);
        
	    drawBadge.setVisible(true);
	    drawErrorPanel.setVisible(true);
        p.setVisible(true);
        totalGUI.setVisible(true);
        
        
        return totalGUI;
	}

	
	public void actionPerformed(ActionEvent e) {  
		if (e.getSource() == shapeOval) {
	      	new Badge2("oval");
	      	drawBadge.repaint();
		}
	    else if (e.getSource() == shapeRect) {
	    	new Badge2("rectangle");
	       	drawBadge.repaint();
	    }
	    else if (e.getSource() == shapeRound) {
	    	new Badge2("rounded");
	    	drawBadge.repaint();
	    }
		
		
		
        if (e.getSource() == fontR) {
	       	fontstyle = "PLAIN";
	       	new Badge2(fontstyle);
	       	drawBadge.repaint();
	    }
	    else if (e.getSource() == fontB) {
	       	fontstyle = "BOLD"; 
	       	new Badge2(fontstyle);
	       	drawBadge.repaint();
	    }
	    else if (e.getSource() == fontI) {
	       	fontstyle = "ITALIC"; 	
	       	new Badge2(fontstyle);
	       	drawBadge.repaint();
	    }
	    else if (e.getSource() == fontBI) {
	      	fontstyle = "BOLDITALIC"; 
	      	new Badge2(fontstyle);
	       	drawBadge.repaint();
	    }
        
        for(int i = 0; i < iColor.length; i++) {
        	if(e.getSource() == colorButtons[i]) {
        		color = iColor[i];
        		new Badge2(1,color);
        		drawBadge.repaint();
        	}
        	
        	if(e.getSource() == bgcolorButtons[i]) {
        		backgroundcolor = iColor[i];
        		new Badge2(0,backgroundcolor);
        		drawBadge.repaint();
        	}
        }
        
        //check if the color is same.
        if (color.equals(backgroundcolor) ) {
        	new ErrorPanel("Your fontground color is the same as background color!");
			drawErrorPanel.repaint();
        }else {
        	new ErrorPanel("");
			drawErrorPanel.repaint();
        }
	}  

	
	//check if only input the number
	public int ifEnterIsNumber(String s) {
		int temple;
		try {
			temple = Integer.parseInt(s);
			noNumberText = "";
		}catch(Exception e) {
			noNumberText = s;
			return 0;
		}
		return temple;
	}
	
	//this method is for check which source from and limit the input. Also can call the ErrorPanel
	public void whichTextIn(DocumentEvent e, String s) {
		try {
			if(e.getDocument() == nameIn.getDocument()) {
				if(!s.equals("")) {
				
						new Badge2(2,s);
					
				}
			}else if(e.getDocument() == widthSizeIn.getDocument()) {
				if(ifEnterIsNumber(s) <= 0 ) {
					if(!s.equals("")) {
						new ErrorPanel("Please only input the positive number!");
						drawErrorPanel.repaint();
					}
				}else if(ifEnterIsNumber(s) > 500 ) {
					new Badge2(0,ifEnterIsNumber(s));
					new ErrorPanel("Please input the width number < 500!");
					drawErrorPanel.repaint();
				}else {
					
					new Badge2(0,ifEnterIsNumber(s));
					drawBadge.repaint();
					if(Badge2.ifError) {
						
						new ErrorPanel("");
						drawErrorPanel.repaint();
					}else {
						
						new ErrorPanel(ErrorPanel.errorText);
						drawErrorPanel.repaint();
					}
					
				}
				
			}else if(e.getDocument() == heightSizeIn.getDocument()) {
				if(ifEnterIsNumber(s) <= 0 ) {
					if(!s.equals("")) {
						new ErrorPanel("Please only input the positive number!");
						drawErrorPanel.repaint();
					}
				}else if(ifEnterIsNumber(s) > 300 ) {
					new Badge2(1,ifEnterIsNumber(s));
					new ErrorPanel("Please input the height number < 300!");
					drawErrorPanel.repaint();
				}else {
					
					new Badge2(1,ifEnterIsNumber(s));
					drawBadge.repaint();
					if(Badge2.ifError) {
						
						new ErrorPanel("");
						drawErrorPanel.repaint();
					}else {
						
						new ErrorPanel(ErrorPanel.errorText);
						drawErrorPanel.repaint();
					}
				}
			}else if(e.getDocument() == fontsizeIn.getDocument()) {
				if(ifEnterIsNumber(s) > 0 ) {
					new Badge2(2,ifEnterIsNumber(s));
					new ErrorPanel("");
					drawErrorPanel.repaint();
					if(ifEnterIsNumber(s) > 90) {
						new Badge2(2,ifEnterIsNumber(s));
						new ErrorPanel("Please input the font size < 90!");
						drawErrorPanel.repaint();
					}
					
					}else {
						if(!s.equals("")) {
							new ErrorPanel("Please only input the positive number!");
							drawErrorPanel.repaint();
						}
					}
			}
			drawBadge.repaint();
		}catch(Exception e2) {
			
		}
		
	}
	
	public static void main(String args[]) {	
		GuiBadge badge = new GuiBadge();	
	}	
	
//those method is for change the value in JTextField in real time	
	@Override
	public void changedUpdate(DocumentEvent e) {
		
		try {
			Document doc = e.getDocument();
			String s = doc.getText(0, doc.getLength());

				whichTextIn(e,s);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}


	@Override
	public void insertUpdate(DocumentEvent e) {
		
		try {
			Document doc = e.getDocument();
			String s = doc.getText(0, doc.getLength());

				whichTextIn(e,s);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}


	@Override
	public void removeUpdate(DocumentEvent e) {
		
		try {
			Document doc = e.getDocument();
			String s = doc.getText(0, doc.getLength());

				whichTextIn(e,s);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}




