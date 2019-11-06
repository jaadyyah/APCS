package karel;
// Jaadyyah SHearrion

import kareltherobot.*;

public class tallHarvester extends UrRobot
{
	public tallHarvester(int street, int avenue, Direction dir, int beeps)
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
	
	public void twoRowGrab() // using this to make the main shorter maybe could've done it like that in the others
	{
		rowGrab();
		rightCornerTurn();
		rowGrab();
		leftCornerTurn();
		
	}

	public static void main(String[] args)
	{
		World.readWorld("WorldFiles/fig3-3b.kwld");
		World.setVisible(true);

		tallHarvester betty = new tallHarvester(2, 2, East, 0);
		World.setDelay(4);
		betty.rowGrab();
		betty.firstLeftCornerTurn();
		betty.twoRowGrab();
		betty.twoRowGrab();
		betty.twoRowGrab();
		betty.rowGrab();
		betty.move();
		betty.turnOff();
	}

}