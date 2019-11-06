package karel;
// Jaadyyah SHearrion

import kareltherobot.*;

public class DiamondHarvester extends UrRobot
{
	public DiamondHarvester(int street, int avenue, Direction dir, int beeps)
	{
		super(street, avenue, dir, beeps);
	}

	public void turnRight()
	{
		super.turnLeft();
		super.turnLeft();
		super.turnLeft();
	}

	public void diagonalUpRowGrab()
	{
		super.move();
		super.pickBeeper();
		facingEastTurn();
		super.pickBeeper();
		facingWestTurn();
		super.pickBeeper();
		facingWestTurn();
		super.pickBeeper();
	}

	public void facingEastTurn() // for up rows
	{
		super.turnLeft();
		super.move();
		super.turnLeft();
		super.move();

	}

	public void facingWestTurn() // for up rows
	{
		turnRight();
		super.move();
		super.turnLeft();
		super.move();
	}

	public void nextRow() // for up rows
	{
		turnRight();
		super.move();
		super.turnLeft();
	}

	public void twoDiagonalRows() // first two
	{
		diagonalUpRowGrab();
		nextRow();
		turnRight();
		turnRight();
		diagonalDownRowGrab();
	}

	public void diagonalDownRowGrab()
	{
		super.move();
		super.pickBeeper();
		moveBetweenBeepersDown();
		super.pickBeeper();
		moveBetweenBeepersDown();
		super.pickBeeper();
		moveBetweenBeepersDown();
		super.pickBeeper();
	}

	public void moveBetweenBeepersDown() // method for the movement between the beepers
	{
		turnRight();
		super.move();
		super.turnLeft();
		super.move();
	}

	public void diagonalLastRows()
	{
		super.move();
		super.pickBeeper();
		super.turnLeft();
		facingWestTurn();
		super.pickBeeper();
		facingWestTurn();
		super.pickBeeper();
		facingWestTurn();
		super.pickBeeper();
		turnRight();
		super.move();
		turnRight();
		diagonalDownRowGrab();
	}

	public static void main(String[] args)
	{
		World.readWorld("WorldFiles/fig3-5.kwld");
		World.setVisible(true);

		DiamondHarvester betty = new DiamondHarvester(2, 2, East, 0);
		World.setDelay(4);
		betty.move();
		betty.move();
		betty.move();
		betty.twoDiagonalRows();
		betty.move();
		betty.turnLeft();
		betty.diagonalLastRows();
		betty.turnOff();
	}

}