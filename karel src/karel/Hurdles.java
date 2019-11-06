package karel;
// jaadyyah shearrion

import kareltherobot.*;

public class Hurdles extends CleverRobot

{
	public Hurdles(int street, int avenue, Direction dir, int beeps)
	{
		super(street, avenue, dir, beeps);
	}

	public static void main(String[] args)
	{
		MakeHurdles.loadRandomWorld();
		World.setVisible(true);

		Hurdles betty = new Hurdles(1, 1, East, 0);
		World.setDelay(4);

		while (!betty.frontIsClear())
		{
			betty.moveUntilTouchingAHurdle();
			betty.goingOverHurdle();
			betty.topPartOfHurdle();
			betty.goDown();
			betty.facingSouthMoveToNextHurdle();
		}
	}

	// pre: facing south and when the robot has finished jumping a hurdle
	// post: should face east then look for the next hurdle
	private void facingSouthMoveToNextHurdle()
	{
		turnLeft();
		moveUntilTouchingAHurdle();
	}

	// pre: on the top of a hurdle and facing south
	// post: should end at the bottom of hurdle and facing south
	private void goDown()
	{
		goToWall();
	}

	// pre: starts facing east and against the hurdle
	// post: is at the top of the hurdle facing east
	private void goingOverHurdle()
	{
		while (!frontIsClear())
		{
			if (!frontIsClear())
			{
				turnLeft();
				move();
				turnRight();
			}
		}
	}

	// pre: is facing east on top of the hurdle
	// post: is facing south on top of the hurdle
	private void topPartOfHurdle()
	{
		move();
		turnRight();
		while (!frontIsClear())
		{
			turnLeft();
			move();
			turnRight();
		}
	}

	// pre: starts facing east
	// post: finds the wall of the hurdle
	private void moveUntilTouchingAHurdle()
	{
		while (frontIsClear())
		{
			move();
		}

	}

}
