/**********************************************************
 * Assignment: Twos
 *
 * Author: Jaadyyah Shearrion 
 *
 * Description: 2048 game
 *
 * Academic Integrity: I pledge that this program represents my own work. I
 * received help from (Sara, Nate) in designing and debugging
 * my program.
 **********************************************************/

package TwosCP1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameView extends JFrame implements IChangeListener
{
	private JLabel status;
	private JLabel score;
	private GameState grid;
	private JLabel[] tiles;

	public GameView(GameState g)
	{
		// set the value for the instance variable grid
		// this next line registers the GameView with the GameState
		grid = g;
		status = new JLabel();
		score = new JLabel();
		tiles = new JLabel[16];
		for (int i = 0; i < 16; i++)
		{
			tiles[i] = new JLabel("");
		}
		grid.addListener(this);
		// create a new ActionHandler object
		ActionHandler handler = new ActionHandler(g);
		// set the title and size
		setTitle("Jaadyyah's version of 2048");
		setSize(400, 400);
		// set the layout to a BorderLayout
		setLayout(new BorderLayout());
		// build a top panel and add it to the NORTH of the BoardLayout
		JPanel top = buildTopPanel(handler);
		add(top, BorderLayout.NORTH);
		// build a center panel and add it to the CENTER of the BoardLayout
		JPanel center = buildCenterPanel(handler);
		add(center, BorderLayout.CENTER);
		// build a bottom panel and add it to the BOTTOM of the BoardLayout
		JPanel bottom = buildBottomPanel();
		add(bottom, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void display()
	{
		setVisible(true);
	}

	@Override
	public void redraw()
	{
		// set the text of these labels: status, score, all the tiles
		status.setText(grid.getStatus());
		score.setText(grid.getScore() + "");
		for (int counter = 0; counter < 16; counter++)
		{
			int row = counter / 4;
			int col = counter % 4;
			tiles[counter].setText(grid.getValue(row, col) + "");
			if (grid.getValue(row, col) == 0)
			{
				tiles[counter].setText("");
			}

		}
		
	}

	private JPanel buildBottomPanel()
	{
		// create a JPanel and use the instance variable status to add a label
		// to the bottom panel
		JPanel b = new JPanel();
		b.add(status);
		b.setBackground(Color.ORANGE);
		return b;

	}

	private JPanel buildTopPanel(ActionHandler handler)
	{
		// create JPanel and add a JButton to it for "New game"
		// also use the instance variable score to add a label
		// the next line registers the button if it were called "button"
		JPanel t = new JPanel();
		JButton button = new JButton("New Game");
		t.add(button, BorderLayout.EAST);
		t.add(score, BorderLayout.WEST);
		button.addActionListener(handler);
		t.setBackground(Color.CYAN);
		return t;
	}

	private JPanel buildCenterPanel(ActionHandler handler)
	{
		// create a JPanel with a GridLayout
		// use the instance variable tiles to fill the grid with labels
		// the next line sets up the arrow keys using the method we gave you
		JPanel c = new JPanel(new GridLayout(4, 4));
		bindArrows(handler, c);
		for (int i = 0; i < 16; i++)
		{
			c.add(tiles[i]);
			tiles[i].setHorizontalAlignment(JLabel.CENTER);
		}
		return c;
	}

	// might need to give the students this method instead of making them
	// learn about key bindings and anonymous inner classes
	private void bindArrows(ActionHandler handler, JPanel panel)
	{
		String[] commands = { "left arrow", "up arrow", "right arrow", "down arrow" };
		for (int i = 0; i < 4; i++)
		{
			int copy = i;
			KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT + i, 0);
			Action action = new AbstractAction()
			{
				public void actionPerformed(ActionEvent e)
				{
					handler.handleArrowPress(GameState.LEFT + copy);
				}
			};
			panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(key, commands[i]);
			panel.getActionMap().put(commands[i], action);
		}
	}
}