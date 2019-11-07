import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener; 

public class SwingCollatz
{
	
	int n = 0;
	int numSteps = 0;
	
	public SwingCollatz()
	{
		JFrame f = new JFrame();
		f.setTitle("Collatz Conjecture Calculator");
		
		JTextField numEntry = new JTextField("Enter number");
		numEntry.setBounds(50, 50, 150, 30);
		f.add(numEntry);
		
		JButton enterButton = new JButton("Compute");
		enterButton.setBounds(200, 50, 150, 30);
		enterButton.setEnabled(false);
		f.add(enterButton);
		
		DefaultListModel<Integer> numsList = new DefaultListModel<Integer>();
		JList<Integer> resultNums = new JList<Integer>(numsList);
		JScrollPane numsDisplay = new JScrollPane(resultNums);
		numsDisplay.setBounds(50, 100, 300, 300);
		f.add(numsDisplay);
		
		JLabel stepsDisplay = new JLabel("Number of steps: ");
		stepsDisplay.setBounds(50, 430, 300, 30);
		f.add(stepsDisplay);
		
		numEntry.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
			}
			public void removeUpdate(DocumentEvent e) {
				try
				{
					n = Integer.parseInt(numEntry.getText());
					if (n > 0)
						enterButton.setEnabled(true);
				}
				catch(Exception except)
				{
					enterButton.setEnabled(false);
				}
			}
			public void insertUpdate(DocumentEvent e) {
				try
				{
					n = Integer.parseInt(numEntry.getText());
					if (n > 0)
						enterButton.setEnabled(true);
				}
				catch(Exception except)
				{
					enterButton.setEnabled(false);
				}
			}
		});
		
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				numsList.clear();
				numsList.addElement(n);
				while (n != 1)
				{
					if (n % 2 == 0)
					{
						n /= 2;
					}
					else
					{
						n *= 3;
						n++;
					}
					numSteps++;
					numsList.addElement(n);
				}
				stepsDisplay.setText("Number of steps: " + numSteps);
				numSteps = 0;
			}
		});
		
		f.setSize(400, 500);
		f.setLayout(null);  
		f.setVisible(true); 
	}

	public static void main(String[] args)
	{
		new SwingCollatz();
	}

}
