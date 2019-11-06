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

import java.util.ArrayList;
import java.util.Arrays;

/* Represents the game state, including status, score, and the 4x4 grid 
 * of values. Knows how to shift the values around. Notifies all 
 * registered IChangeListeners if anything happens. 
 */
public class GameState
{
	private int[][] values;
	private String status;
	private int score;

	public final static int LEFT = 0;
	public final static int UP = 1;
	public final static int RIGHT = 2;
	public final static int DOWN = 3;

	private ArrayList<IChangeListener> listeners;

	// initialize listeners, status, and score
	public GameState()
	{
		status = "";
		score = 0;
		values = new int[4][4];
		listeners = new ArrayList<IChangeListener>();
	}

	public String getStatus()
	{
		return status;
	}

	public int getScore()
	{
		return score;
	}

	public void addListener(IChangeListener listener)
	{
		// add the listener to the arrayList of listeners
		listeners.add(listener);
	}

	public void newGame()
	{
		// fill values array with 16 random numbers from 0 - 15
		int spawnedTiles = 0;
		values = new int[4][4];
		int r = (int) (Math.random() * 4);
		int c = (int) (Math.random() * 4);
		while (spawnedTiles < 2)
		{
			if (values[r][c] == 0)
			{
				values[r][c] = getNewTile();
				spawnedTiles++;
			} else
			{
				r = (int) (Math.random() * 4);
				c = (int) (Math.random() * 4);
			}
		}
		// change status, and update listeners
		status = "New game started";
		score = 0;
		updateListeners();
	}

	public int getNewTile()
	{
		int rand = (int) (Math.random() * 10);
		if (rand == 0)
		{
			return 4;
		}
		return 2;
	}

	public void shift(int direction)
	{
		// change status and update listeners
		moveTiles(direction);

		int spawnedTiles = 0;
		int r = (int) (Math.random() * 4);
		int c = (int) (Math.random() * 4);
		while (spawnedTiles < 1 && openSpace())
		{
			if (values[r][c] == 0)
			{
				values[r][c] = getNewTile();
				spawnedTiles++;
			} else
			{
				r = (int) (Math.random() * 4);
				c = (int) (Math.random() * 4);
			}
		}
		status = "Tiles shifted " + direction;
		updateListeners();
	}

	private boolean openSpace()
	{
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if (values[i][j] == 0)
				{
					return true;
				}
			}
		}
		status = "Board is full";
		return false;
	}

	private void moveTiles(int direction)
	{
		int[][] array = copyArray(values);
		// movement for left
		if (direction == 0)
		{
			left(array);
			mergeLeft(array);
			left(array);
			// movement for up
		} else if (direction == 1)
		{
			up(array);
			mergeUp(array);
			up(array);
			// movement for right
		} else if (direction == 2)
		{
			right(array);
			mergeRight(array);
			right(array);
			// movement for down
		} else if (direction == 3)
		{
			down(array);
			mergeDown(array);
			down(array);
		}
		updateBoard(array);
	}

	private void mergeDown(int[][] array)
	{
		for (int i = 0; i < 4; i++)
		{
			for (int j = 3; j > 0; j--)
			{
				if (array[j][i] == array[j - 1][i])
				{
					array[j][i] *= 2;
					score += array[j][i];
					array[j - 1][i] = 0;
				}
			}
		}
	}

	private void down(int[][] array)
	{
		for (int i = 0; i < 4; i++)
		{
			int counter = 3;
			for (int j = 3; j > -1; j--)
			{
				if (array[j][i] != 0)
				{
					int temp = array[j][i];
					array[j][i] = 0;
					array[counter][i] = temp;
					counter--;
				}
			}
		}
	}

	private void mergeRight(int[][] array)
	{
		for (int i = 0; i < 4; i++)
		{
			for (int j = 3; j > 0; j--)
			{
				if (array[i][j] == array[i][j - 1])
				{
					array[i][j] *= 2;
					score += array[i][j];
					array[i][j - 1] = 0;
				}
			}
		}
	}

	private void right(int[][] array)
	{
		for (int i = 0; i < 4; i++)
		{
			int counter = 3;
			for (int j = 3; j > -1; j--)
			{
				if (array[i][j] != 0)
				{
					int temp = array[i][j];
					array[i][j] = 0;
					array[i][counter] = temp;
					counter--;
				}
			}
		}
	}

	private void mergeUp(int[][] array)
	{
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (array[j][i] == array[j + 1][i])
				{
					array[j][i] *= 2;
					score += array[j][i];
					array[j + 1][i] = 0;
				}
			}
		}
	}

	private void up(int[][] array)
	{
		for (int i = 0; i < 4; i++)
		{
			int counter = 0;
			for (int j = 0; j < 4; j++)
			{
				if (array[j][i] != 0)
				{
					int temp = array[j][i];
					array[j][i] = 0;
					array[counter][i] = temp;
					counter++;
				}
			}
		}
	}

	private void updateBoard(int[][] array)
	{
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				values[i][j] = array[i][j];
			}
		}
	}

	private void mergeLeft(int[][] array)
	{
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (array[i][j] == array[i][j + 1])
				{
					array[i][j] *= 2;
					score += array[i][j];
					array[i][j + 1] = 0;
				}
			}
		}
	}

	private void left(int[][] array)
	{
		for (int i = 0; i < 4; i++)
		{
			int counter = 0;
			for (int j = 0; j < 4; j++)
			{
				if (array[i][j] != 0)
				{
					int temp = array[i][j];
					array[i][j] = 0;
					array[i][counter] = temp;
					counter++;
				}
			}
		}
	}

	private int[][] copyArray(int[][] newValues)
	{
		int[][] array = new int[4][4];
		for (int i = 0; i < 4; i++)
		{
			for (int k = 0; k < 4; k++)
			{
				array[i][k] = values[i][k];
			}
		}
		return array;
	}

	public int getValue(int r, int c)
	{
		// return the appropriate value
		return values[r][c];
	}

	private void updateListeners()
	{
		// for each item in the listeners list calls its redraw method
		for (IChangeListener i : listeners)
		{
			i.redraw();
		}
	}
}