package TripleWithRadio;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TripleWithRadioButtonsPanel extends JPanel {
	public TripleWithRadioButtonsPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createRigidArea(new Dimension(5, 0)));
		JLabel label;
		label = new JLabel("Hi.");
		label.setBounds(50, 100, 100, 30);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(label);

		JTextField textField = new JTextField();

		textField.setPreferredSize(new Dimension(170, 20));
		textField.setMaximumSize(textField.getPreferredSize());
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(textField);

		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout());
		JButton button1 = new JButton("Append");
		JButton button2 = new JButton("Reset");
		panelButton.add(button1);
		panelButton.add(button2);
		this.add(panelButton);

		ButtonGroup group = new ButtonGroup();
		JRadioButton radio1 = new JRadioButton("lowercase");
		radio1.setAlignmentX(Component.CENTER_ALIGNMENT);
		radio1.setAlignmentY(Component.TOP_ALIGNMENT);
		JRadioButton radio2 = new JRadioButton("UPPERCASE");
		radio2.setAlignmentX(Component.CENTER_ALIGNMENT);
		group.add(radio1);
		group.add(radio2);

		this.add(radio1);
		this.add(radio2);

		
		JPanel Bottompanel = new JPanel();
		this.add(Bottompanel);
}
}
