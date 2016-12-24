package car.model;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton createCar;
	private JButton close;
	private JComboBox<String> carColor;
	private JComboBox<String> carSize;
	public Menu(){
		setSize(350, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Choose Your Car");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout());
		JPanel dropdownPanel = new JPanel();
		dropdownPanel.setLayout(new FlowLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("Please choose the color and size of your car");
		String[] colors = {"", "Blue", "Red", "Green", "Yellow", "Black"};
		carColor = new JComboBox<String>(colors);
		String[] sizes = {"", "Small", "Medium", "Large"};
		carSize = new JComboBox<String>(sizes);
		createCar = new JButton("Create My Car");
		close = new JButton("Exit");
		createCar.addActionListener(this);
		close.addActionListener(this);
		
		labelPanel.add(label);
		dropdownPanel.add(carColor);
		dropdownPanel.add(carSize);
		buttonPanel.add(createCar);
		buttonPanel.add(close);
		mainPanel.add(labelPanel, BorderLayout.NORTH);
		mainPanel.add(dropdownPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		setContentPane(mainPanel);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == createCar){
			if(carColor.getSelectedItem().equals("") || carSize.getSelectedItem().equals("")){
				JOptionPane.showMessageDialog(null, "I'm sorry, but you must choose a car color and a car size before proceeding", "Warning", 2);
			}else{
				this.setVisible(false);
				String color = (String) carColor.getSelectedItem();
				String size = (String) carSize.getSelectedItem();
				
				new Car(color, size);
			}
		}else if(e.getSource() == close){
			System.exit(0);
		}
	}
	
}
