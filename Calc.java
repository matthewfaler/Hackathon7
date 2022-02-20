import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calc implements ActionListener {
	
	JFrame fra;
	JPanel pan;
	JTextField txt;
	JButton[] nums = new JButton[10];
	JButton add = new JButton("+");
	JButton sub = new JButton("-");
	JButton mul = new JButton("*");
	JButton div = new JButton("/");
	JButton dec = new JButton(".");
	JButton equal = new JButton("=");
	JButton clr = new JButton("clr");
	JButton del = new JButton("del");
	JButton neg = new JButton("(-)");
	JButton[] actions = {add, sub, mul, div, dec, equal, clr, del, neg};
	
	Font fon = new Font(Font.SANS_SERIF, Font.BOLD, 35);
	double num1 = 0.0, num2 = 0.0, result = 0.0;
	char operator;
	
	Calc() {
		fra = new JFrame("Calculator");
		fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fra.setSize(400, 530);
		fra.setLayout(null);
		txt = new JTextField();
		txt.setBounds(20, 20, 360, 80);
		txt.setFont(fon);
		txt.setEditable(false);
		
		for(int i = 0; i < 9; i++) {
			actions[i].addActionListener(this);
			actions[i].setFont(fon);
		}
		
		for(int i = 0; i < 10; i++) {
			nums[i] = new JButton(String.valueOf(i));
			nums[i].addActionListener(this);
			nums[i].setFont(fon);
		}
		pan = new JPanel();
		pan.setBounds(20, 120, 360, 280);
		pan.setLayout(new GridLayout(4, 4));
		pan.add(nums[1]);
		pan.add(nums[2]);
		pan.add(nums[3]);
		pan.add(add);
		pan.add(nums[4]);
		pan.add(nums[5]);
		pan.add(nums[6]);
		pan.add(sub);
		pan.add(nums[7]);
		pan.add(nums[8]);
		pan.add(nums[9]);
		pan.add(mul);
		pan.add(dec);
		pan.add(nums[0]);
		pan.add(equal);
		pan.add(div);
		neg.setBounds(25, 400, 110, 80);
		del.setBounds(145, 400, 110, 80);
		clr.setBounds(265, 400, 110, 80);
		fra.add(pan);
		fra.add(neg);
		fra.add(del);
		fra.add(clr);
		fra.add(txt);
		fra.setVisible(true);
	}
	

	public static void main(String[] args) {
		Calc cal = new Calc();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == nums[i]) {
				txt.setText(txt.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == dec) {
			txt.setText(txt.getText().concat("."));
		}
		if(e.getSource() == add) {
			num1 = Double.parseDouble(txt.getText());
			operator = '+';
			txt.setText("");
		}
		if(e.getSource() == sub) {
			num1 = Double.parseDouble(txt.getText());
			operator = '-';
			txt.setText("");
		}
		if(e.getSource() == mul) {
			num1 = Double.parseDouble(txt.getText());
			operator = '*';
			txt.setText("");
		}
		if(e.getSource() == div) {
			num1 = Double.parseDouble(txt.getText());
			operator = '/';
			txt.setText("");
		}
		if(e.getSource() == equal) {
			num2 = Double.parseDouble(txt.getText());
			switch(operator) {
			case'+':
				result = num1 + num2;
				break;
			case'-':
				result = num1 - num2;
				break;
			case'*':
				result = num1 * num2;
				break;
			case'/':
				result = num1 / num2;
				break;
			}
			txt.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource() == clr) {
			txt.setText("");
			num1 = 0.0;
		}
		if(e.getSource() == del) {
			String str = txt.getText();
			txt.setText("");
			for(int i = 0; i < str.length() - 1; i++) {
				txt.setText(txt.getText() + str.charAt(i));
			}
		}
		if(e.getSource() == neg) {
			double n = Double.parseDouble(txt.getText());
			n = n * -1.0;
			txt.setText(String.valueOf(n));
		}
	}
}
