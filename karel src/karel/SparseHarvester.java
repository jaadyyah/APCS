package karel;
// Jaadyyah SHearrion

import kareltherobot.*;

public class SparseHarvester extends Robot
{
	public SparseHarvester(int street, int avenue, Direction dir, int beeps)
	{
		super(street, avenue, dir, beeps);
	}

	public void turnRight()
	{
		super.turnLeft();
		super.turnLeft();
		super.turnLeft();
	}

	public void beeperGrab()
	{
		if (nextToABeeper())
		{
			pickBeeper();
			move();
		} else
		{
			move();
		}
	}

	public void rowGrab()
	{
		beeperGrab();
		beeperGrab();
		beeperGrab();
		beeperGrab();
		beeperGrab();
		beeperGrab();
	}

	public void rightCornerTurn() // pretty straight forward
	{
		turnRight();
		super.move();
		turnRight();
	}

	public void leftCornerTurn()
	{
		turnLeft();
		move();
		turnLeft();
	}

	public void firstThreeRows()
	{
		rowGrab();
		leftCornerTurn();
		rowGrab();
		rightCornerTurn();
		rowGrab();
		leftCornerTurn();
	}

	public void lastThreeRows()
	{
		rowGrab();
		rightCornerTurn();
		rowGrab();
		leftCornerTurn();
		rowGrab();
	}

	public static void main(String[] args)
	{
		SparseWorld.loadRandomWorld();
		World.setVisible(true);

		SparseHarvester betty = new SparseHarvester(2, 2, East, 0);
		World.setDelay(4);
		betty.firstThreeRows();
		betty.lastThreeRows();
		betty.turnOff();
	}

}