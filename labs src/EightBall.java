
/**********************************************************
 * Assignment: Magic 8Ball
 *
 * Author: Jaadyyah Shearrion
 *
 * Description: does the eightball things yah 
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from (Sara) in designing and debugging
 * my program.
 **********************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EightBall extends JFrame implements ActionListener
{
	private JButton message;

	public static void main(String[] args)
	{
		EightBall ball = new EightBall();
		ball.display();
	}

	public EightBall()
	{
		message = new JButton("Ask me a question and Click to shake me");
		message.addActionListener(this);
		add(message);
		setTitle("EightBall");
		setSize(400, 400);
	}

	public void display()
	{
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent click)
	{
		String[] responses = { "Nope", "Not at all", "Maybe", "Yes silly!", "Of course!" };
		if (click.getActionCommand().equals("Ask me a question and Click to shake me"))
		{
			message.setText(responses[(int) (Math.random() * 5)]);
		} else
		{
			message.setText("Ask me a question and Click to shake me");
		}
	}
}