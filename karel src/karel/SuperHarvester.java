package karel;
// Jaadyyah Shearrion

import kareltherobot.*;

public class SuperHarvester extends CleverRobot
{
	public SuperHarvester(int street, int avenue, Direction dir, int beeps)
	{
		super(street, avenue, dir, beeps);
	}

	// pre: start 1 block away from beeper row
	// post: grabs every beeper in the row
	public void rowGrab()
	{
		move();
		while (nextToABeeper())
		{
			pickBeeperPile();
			move();
		}

	}

	// pre: facing west, avenue 2, cleared row behind it,
	// post: facing east, avenue 2, 1 block away from the next row
	public void rightCornerTurn()
	{
		turnRight();
		move();
		turnRight();
	}

	// pre: facing east, avenue 7, complete row cleared
	// post: facing west, 1 street up
	public void leftCornerTurn()
	{
		turnLeft();
		move();
		turnLeft();
	}

	// pre: all beepers must have been taken
	// post: 1, 1, facing north
	public void goToOrigin()
	{
		faceWest();
		goToWall();
		faceSouth();
		goToWall();
		faceNorth();
	}

	// pre: starts at 2,2 and 1 block away from the row.
	// post: completes an entire row when it knows a beeper is there
	public void checkRowForBeepersAndCollectRow()
	{
		move();
		if (nextToABeeper())
		{
			pickBeeperPile();
			rowGrab();
		} else
		{
			goToOrigin();
			turnOff();
		}
	}

	// pre: anything from the start of the program to the end
	// post: clears a row of beepers after it checks if there is a beeper row
	public void loopForCheckBeeper()
	{

		if (frontIsClear())
		{
			checkRowForBeepersAndCollectRow();
		}
	}

	// pre: can start from anywhere and be able to complete the post
	// post: picks up all the beepers in the program, checks the next row to make
	// sure that there isn't anymore beepers, then go to the origin
	public void infiniteLoop()
	{
		while (true)
		{
			checkRowForBeepersAndCollectRow();
			leftCornerTurn();
			loopForCheckBeeper();
			rightCornerTurn();
		}
	}

	public static void main(String[] args)
	{
		SuperField.loadRandomWorld();
		World.setVisible(true);

		SuperHarvester betty = new SuperHarvester(2, 2, East, 0);
		World.setDelay(4);
		betty.infiniteLoop();

	}

}