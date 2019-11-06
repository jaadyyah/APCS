package karel;

import kareltherobot.*;

public class CleverRobot extends Robot
{
	public CleverRobot(int street, int avenue, Direction dir, int beeps)
	{
		super(street, avenue, dir, beeps);
	}

	public void turnRight()
	{
		turnLeft();
		turnLeft();
		turnLeft();
	}

	public void faceNorth()
	{
		while (!facingNorth())
		{
			turnLeft();
		}
	}
	
	public void faceEast()
	{
		while (!facingEast())
		{
			turnLeft();
		}
	}
	
	public void faceSouth()
	{
		while (!facingSouth())
		{
			turnLeft();
		}
	}
	
	public void faceWest()
	{
		while (!facingWest())
		{
			turnLeft();
		}
	}
	
	// precondition: robot is facing a wall some distance away
	// postcondition: robot is facing the wall half a block away
	public void goToWall()
	{
		while (frontIsClear())
		{
			move();
		}
	}
	
	// precondition: none
	// postcondition: robot has not moved, corner is clear of beepers
	public void pickBeeperPile()
	{
		while (nextToABeeper())
		{
			pickBeeper();
		}
	}

}