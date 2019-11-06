package karel;
// Jaadyyah Shearrion

import kareltherobot.*;

public class Harvester extends UrRobot
{
	public Harvester(int street, int avenue, Direction dir, int beeps)
	{
		super(street, avenue, dir, beeps);
	}

	public void turnRight()
	{
		super.turnLeft();
		super.turnLeft();
		super.turnLeft();
	}

	public void rowGrab() // grabs a row of beepers
	{
		super.move();
		super.pickBeeper();
		super.move();
		super.pickBeeper();
		super.move();
		super.pickBeeper();
		super.move();
		super.pickBeeper();
	}

	public void firstLeftCornerTurn() // the first left corner is a bit tricky to get the code to work
	{
		super.move();
		super.pickBeeper();
		super.turnLeft();
		super.move();
		super.turnLeft();
		super.pickBeeper();
	}

	public void rightCornerTurn() // pretty straight forward
	{
		turnRight();
		super.move();
		super.pickBeeper();
		turnRight();
	}

	public void leftCornerTurn()
	{
		super.turnLeft();
		super.move();
		super.pickBeeper();
		super.turnLeft();
	}

	public static void main(String[] args)
	{
		World.readWorld("WorldFiles/fig3-2.kwld");
		World.setVisible(true);

		Harvester betty = new Harvester(2, 2, East, 0);
		World.setDelay(4);
		betty.rowGrab();
		betty.firstLeftCornerTurn();
		betty.rowGrab();
		betty.rightCornerTurn();
		betty.rowGrab();
		betty.leftCornerTurn();
		betty.rowGrab();
		betty.rightCornerTurn();
		betty.rowGrab();
		betty.leftCornerTurn();
		betty.rowGrab();
		betty.move();
		betty.turnOff();
	}

}