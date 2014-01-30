/**
 * Simple Swing example
 * Control speed and rotation of the fan
 * with provided buttons
 */

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FanSpeed extends JFrame{
	private JButton jbtRotateLeft = new JButton("RotateLeft");
	private JButton jbtRotateRight = new JButton("RotateRight");
	private JButton jbtUpSpeed = new JButton("UpSpeed");
	private JButton jbtDownSpeed = new JButton("DownSpeed");
	
	private ArcsPanel arcPanel = new ArcsPanel();
	
	public FanSpeed(){
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(2,2,5,5));
		jbtRotateLeft.setToolTipText("press to change rotaion to LEFT");
		jbtRotateRight.setToolTipText("press to change rotaion to RIGHT");
		jbtUpSpeed.setToolTipText("press to increase speed of rotation");
		jbtDownSpeed.setToolTipText("press to decrease speed of rotation");
		buttonsPanel.add(jbtRotateLeft);
		buttonsPanel.add(jbtRotateRight);
		buttonsPanel.add(jbtUpSpeed);
		buttonsPanel.add(jbtDownSpeed);
		
		this.add(arcPanel,BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.EAST);
		
		jbtRotateLeft.addActionListener(new Listener());
		jbtRotateRight.addActionListener(new Listener());
		jbtUpSpeed.addActionListener(new Listener());
		jbtDownSpeed.addActionListener(new Listener());
		
	}

	public static void main(String[] args) {
		FanSpeed frame = new FanSpeed();
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class Listener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	      if (e.getSource() == jbtRotateLeft)
	    	  arcPanel.rotateLeft();
	      else if (e.getSource() == jbtRotateRight)
	    	  arcPanel.rotateRight();
	      else if (e.getSource() == jbtUpSpeed)
	    	  arcPanel.upSpeed();
	      else if (e.getSource() == jbtDownSpeed)
	    	  arcPanel.downSpeed();
	    }
	  }
	
	class ArcsPanel extends JPanel {
		  // Draw four blazes of a fan
		private int rotateIndex = 0;
		private int speedIndex = 5;
		boolean turnLeft = true;
		Timer timer = new Timer(100*speedIndex, new TimerListener());
		
		//actions to take for buttons pressed
		public void rotateLeft(){
			turnLeft = true;
		}
		public void rotateRight(){
			turnLeft = false;
		}
		public void downSpeed(){
			if (speedIndex < 10){
				speedIndex++;
				timer.setDelay(100*speedIndex);
			}
		}
		public void upSpeed(){
			if (speedIndex > 1){
				speedIndex--;
				timer.setDelay(100*speedIndex);
			}
		}
		public ArcsPanel(){
		    timer.start();
		}
		
		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		
		    int xCenter = getWidth() / 2;
		    int yCenter = getHeight() / 2;
		    int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
		
		    int x = xCenter - radius;
		    int y = yCenter - radius;
		
		    g.fillArc(x, y, 2 * radius, 2 * radius, 0+30*rotateIndex, 30);
		    g.fillArc(x, y, 2 * radius, 2 * radius, 90+30*rotateIndex, 30);
		    g.fillArc(x, y, 2 * radius, 2 * radius, 180+30*rotateIndex, 30);
		    g.fillArc(x, y, 2 * radius, 2 * radius, 270+30*rotateIndex, 30);
		  }
		  class TimerListener implements ActionListener {
		      /** Handle ActionEvent */
		      public void actionPerformed(ActionEvent e) {
		    	  if (turnLeft){
		    		if (rotateIndex < 2)
		  				rotateIndex++;
		  			else
		  				rotateIndex = 0;
		    	  }
		    	  else{
		    		if (rotateIndex > 0)
		  				rotateIndex--;
		  			else
		  				rotateIndex = 2;
		    	  }
		        repaint();
		      }
		  }
	}
}
