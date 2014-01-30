/**
 * A simple Swing example
 * move the circle on the panel 
 * by pressing provided buttons
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircleInPanel extends JFrame{
	private JButton jbtUpLeft = new JButton("UpLeft");
	private JButton jbtLeft = new JButton("Left");
	private JButton jbtDownLeft = new JButton("DownLeft");
	private JButton jbtUp = new JButton("Up");
	private JButton jbtCenter = new JButton("Center");
	private JButton jbtDown = new JButton("Down");
	private JButton jbtUpRight = new JButton("UpRight");
	private JButton jbtRight = new JButton("Right");
	private JButton jbtDownRight = new JButton("DownRight");
	
	private CirclePanel canvas = new CirclePanel();
	
	public CircleInPanel(){
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(3,3));
		bottomPanel.add(jbtUpLeft);
		bottomPanel.add(jbtUp);
		bottomPanel.add(jbtUpRight);
		bottomPanel.add(jbtLeft);
		bottomPanel.add(jbtCenter);
		bottomPanel.add(jbtRight);
		bottomPanel.add(jbtDownLeft);
		bottomPanel.add(jbtDown);
		bottomPanel.add(jbtDownRight);
		
		this.add(canvas, BorderLayout.CENTER); // Add canvas to center
	    this.add(bottomPanel, BorderLayout.SOUTH); // Add buttons to the frame 
	    
	    jbtUpLeft.addActionListener(new Listener());
	    jbtUp.addActionListener(new Listener());
	    jbtUpRight.addActionListener(new Listener());
	    jbtLeft.addActionListener(new Listener());
	    jbtCenter.addActionListener(new Listener());
	    jbtRight.addActionListener(new Listener());
	    jbtDownLeft.addActionListener(new Listener());
	    jbtDown.addActionListener(new Listener());
	    jbtDownRight.addActionListener(new Listener());
	}

	public static void main(String[] args) {
		JFrame frame = new CircleInPanel();
		frame.setTitle("Exercise16_3");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);;
	}
	
	class Listener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	      if (e.getSource() == jbtUpLeft)
	    	  canvas.upLeft(); 
	      else if (e.getSource() == jbtLeft)
	    	  canvas.left();
	      else if (e.getSource() == jbtDownLeft)
	    	  canvas.downLeft(); 
    	  else if (e.getSource() ==jbtUp)
    		  canvas.up(); 
    	  else if (e.getSource() ==jbtCenter)
    		  canvas.center(); 
    	  else if (e.getSource() ==jbtDown)
    		  canvas.down(); 
    	  else if (e.getSource() ==jbtUpRight)
    		  canvas.upRight(); 
    	  else if (e.getSource() ==jbtRight)
    		  canvas.right(); 
    	  else if (e.getSource() ==jbtDownRight)
    		  canvas.downRight(); 
	    }
	  }
	
	class CirclePanel extends JPanel {
		private int radius = 20;
	    private int coordinateX;
	    private int coordinateY; 
	    private int x = 0;
	    private int y = 0;
	      
	    public void upLeft() {
	    	x-=10;
	    	y-=10;
	    	repaint();
	    }
	    
	    public void left() {
	    	x-=10;
	    	repaint();
	    }
	    
	    public void downLeft() {
	    	x-=10;
	    	y+=10;
	    	repaint();
	    }
	    
	    public void up() {
	    	y-=10;
	    	repaint();
	    }
	    
	    public void center() {
	    	x = 0;
	    	y = 0;
	    	repaint();
	    }
	    
	    public void down() {
	    	y+=10;
	    	repaint();
	    }
	    
	    public void upRight() {
	    	x+=10;
	    	y-=10;
	    	repaint();
	    }
	    
	    public void right() {
	    	x+=10;
	    	repaint();
	    }
	    
	    public void downRight() {
	    	x+=10;
	    	y+=10;
	    	repaint();
	    }
	    
	    /** Repaint the circle */
	    protected void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      coordinateX = getWidth() / 2 - radius + x;
	      coordinateY = getHeight() / 2 - radius + y;
	      g.drawOval(coordinateX, coordinateY, 2 * radius, 2 * radius);
	    }
	  }  

}
