// Class that draws circle
package TestGUI;

import java.awt.Color;  
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;



class drawCircle extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int d = 20;
	
	int rValue,gValue,bValue;
	
	// method to draw circle 
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.fillOval(10, 10,d,d);
		
		
	}
	
	// set method to set new diameter
	public void setD(int newD) {
		
		d = (newD>= 0 ? newD : 20 );
		repaint();
	}
	
	// get method 
	public int getD() {
		
		return d;
	}
	

	public Dimension getPreferredSize() {
		return new Dimension(150,150);
	}
	public Dimension getMiminumSize() {
		return getPreferredSize();
	}
	
	//method to set new color
	public void setNewColor() {
		
		Color color = new Color(rValue,gValue,bValue);
		setForeground(color);
	}
	
	//method to show new color and return hex ref
	public String getNewColorHex() {
		
		Color color = new Color(rValue,gValue,bValue);
		return Integer.toString(color.getRGB() & 0xffffff,16);
	}

   
	

	
	
}


