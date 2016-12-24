package car.model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Car implements ActionListener {
	
	private JButton repaint;
	private JButton close;
	private JButton restart;
	private static Color carColor;
	private static JFrame frame;
	private static String size;
	private JComboBox<String> colorBox;
	
	public Car(String color, String size){
		Car.size = size;
		
		frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My Model");
		setColor(color);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		repaint = new JButton("Repaint");
		repaint.addActionListener(this);
		restart = new JButton("Build new model");
		restart.addActionListener(this);
		close = new JButton("Exit");
		close.addActionListener(this);
		
		JLabel colorLabel = new JLabel("New Color:");
		String colors[] = {"Blue", "Red", "Green", "Yellow", "Black"};
		colorBox = new JComboBox<String>(colors);
		colorBox.setSelectedItem(color);
		
		buttonPanel.add(colorLabel);
		buttonPanel.add(colorBox);
		buttonPanel.add(repaint);
		buttonPanel.add(restart);
		buttonPanel.add(close);
		
		frame.setContentPane(new DrawCar());
		frame.getContentPane().setLayout(new BorderLayout());
		
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
	
	public void setColor(String color){
		switch(color){
		case "Blue":
			carColor = Color.BLUE;
			break;
		case "Red":
			carColor = Color.RED;
			break;
		case "Green":
			carColor = Color.GREEN;
			break;
		case "Yellow":
			carColor = Color.YELLOW;
			break;
		case "Black":
			carColor = Color.BLACK;
			break;
		default:
			JOptionPane.showMessageDialog(null, "Please choose a car color before repainting", "Warning", 2);
		}
		frame.getContentPane().repaint();
	}
	
	static class DrawCar extends JPanel {
		private static final long serialVersionUID = 1L;
		private Graphics graphics;
		private int multiplier;
		private int offset;
		
		public void paintComponent(Graphics g) {
			graphics = g;
			multiplier = 0;
			offset = 0;
			int start = 0;
			int window = 150;
			int width = 100;
			int height = 0;
			switch(size){
			case "Small":
				multiplier = 1;
				offset = 200;
				break;
			case "Medium":
				multiplier = 2;
				height = 30;
				break;
			case "Large":
				multiplier = 3;
				height = 50;
				break;
			}
			frame.setSize((window * multiplier) + ((width + offset) * multiplier), (window * multiplier) + (30 * multiplier) - (height * multiplier));
			start = (frame.getWidth() / (2*multiplier)) - 100;
			
			int xpoints[] = {(25 + start)*multiplier, (25 + start)*multiplier, (21 + start)*multiplier, (23 + start)*multiplier, (152 + start)*multiplier, (153 + start)*multiplier, (150 + start)*multiplier, (148 + start)*multiplier, (105 + start)*multiplier, (90 + start)*multiplier, (57 + start)*multiplier, (50 + start)*multiplier, (25 + start)*multiplier};
			int ypoints[] = {50*multiplier, 60*multiplier, 61*multiplier, 70*multiplier, 70*multiplier, 63*multiplier, 62*multiplier, 52*multiplier, 45*multiplier, 30*multiplier, 30*multiplier, 45*multiplier, 50*multiplier};
			int npoints = xpoints.length;
			
			int window1x[] = {(59 + start)*multiplier, (53 + start)*multiplier, (70 + start)*multiplier, (70 + start)*multiplier, (60 + start)*multiplier};
			int window1y[] = {32*multiplier, 45*multiplier, 45*multiplier, 32*multiplier, 32*multiplier};
			int window1Points = window1x.length;
			
			int window2x[] = {(73 + start)*multiplier, (73 + start)*multiplier, (101 + start)*multiplier, (88 + start)*multiplier, (73 + start)*multiplier};
			int window2y[] = {32*multiplier, 45*multiplier, 45*multiplier, 32*multiplier, 32*multiplier};
			int window2Points = window2x.length;
			
			graphics.setColor(Color.GREEN);
			graphics.fillRect(0, 50*multiplier, frame.getWidth(), frame.getHeight() - 50*multiplier);
			graphics.setColor(Color.DARK_GRAY);
			graphics.fillRect(0, 75*multiplier, frame.getWidth(), 10*multiplier);
			graphics.setColor(Color.CYAN);
			graphics.fillRect(0, 0, frame.getWidth(), 58*multiplier);
			
			graphics.setColor(carColor);
			graphics.fillPolygon(xpoints, ypoints, npoints);
			graphics.setColor(Color.BLACK);
			graphics.drawPolygon(xpoints, ypoints, npoints);
			graphics.fillOval((40 + start)*multiplier, 60*multiplier, 20*multiplier, 20*multiplier);
		    graphics.fillOval((105 + start)*multiplier, 60*multiplier, 20*multiplier, 20*multiplier);
		    graphics.setColor(Color.DARK_GRAY);
		    graphics.drawOval((40 + start)*multiplier, 60*multiplier, 20*multiplier, 20*multiplier);
		    graphics.drawOval((105 + start)*multiplier, 60*multiplier, 20*multiplier, 20*multiplier);
		    graphics.setColor(Color.GRAY);
		    graphics.fillOval((45 + start)*multiplier, 65*multiplier, 10*multiplier, 10*multiplier);
		    graphics.fillOval((110 + start)*multiplier, 65*multiplier, 10*multiplier, 10*multiplier);
		    
		    graphics.drawPolygon(window1x, window1y, window1Points);
		    graphics.drawPolygon(window2x, window2y, window2Points);
		    
		    graphics.setColor(Color.WHITE);
		    graphics.fillPolygon(window1x, window1y, window1Points);
		    graphics.fillPolygon(window2x, window2y, window2Points);
		    
		    graphics.setColor(Color.WHITE);
		    smallCloud(8 + (offset/2), 30);
		    mediumCloud(14 + (offset/2), 28);
		    largeCloud(100 + (offset/2), 5);
		    mediumCloud(85 + (offset/2), 10);
		    mediumCloud(145 + (offset/2), 15);
		    mediumCloud(200 + (offset/2), 25);
		}
		
		public void smallCloud(int x, int y){
			graphics.fillOval(x*multiplier, y*multiplier, 10*multiplier, 5*multiplier);
		}
		public void mediumCloud(int x, int y){
			graphics.fillOval(x*multiplier, y*multiplier, 25*multiplier, 10*multiplier);
		}
		public void largeCloud(int x, int y){
			graphics.fillOval(x*multiplier, y*multiplier, 60*multiplier, 20*multiplier);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == repaint){
			setColor((String) colorBox.getSelectedItem());
		}else if(e.getSource() == close){
			System.exit(0);
		}else if(e.getSource() == restart){
			frame.dispose();
			new Menu();
		}
	}
}
