package karel;

// Fritz and Jaadyyah 
import kareltherobot.*;

public class FencePlanter2 extends CleverRobot
{
	public FencePlanter2(int street, int avenue, Direction dir, int beeps)
	{
		super(street, avenue, dir, beeps);
	}

	public static void main(String[] args)
	{
		// this line sets up for the double layer problem
		MakeRectangle2.loadRandomWorld();
		World.setVisible(true);

		FencePlanter2 betty = new FencePlanter2(1, 1, North, 0);
		World.setDelay(2);

		betty.findThePile();
		betty.pickBeeperPile();
		;
		betty.findRectangle();
		for (int i = 0; i < 4; i++)
		{
			betty.plantASide();
			betty.plantCorner();
		}
		for (int i = 0; i < 4; i++)
		{
			betty.secondLayer();
			betty.secondCorner();
		}

		betty.turnOff();
	}

	// pre: finished second layer, away from corner
	// post: planted the corner, facing the wall, ready for planting layer
	private void secondCorner()
	{
		turnAround();
		move();
		putBeeper();
		turnRight();
		move();
		putBeeper();
		turnRight();
		move();
		putBeeper();
		move();
		turnRight();
		move();
	}

	private void turnAround()
	{
		turnLeft();
		turnLeft();
	}

	// pre: completes first layer, facing wall
	// post: complete second layer of first wall, facing east
	private void secondLayer()
	{
		while (!frontIsClear())
		{
			turnAround();
			move();
			putBeeper();
			turnRight();
			move();
			turnRight();
			move();
		}
	}

	// pre: Robot at empty corner facing down the next side to be planted
	// post: Robot has planted a beeper and setup to start new side (facing
	// wall)
	public void plantCorner()
	{
		putBeeper();
		move();
		turnRight();
	}

	// pre: Robot at first section of wall, facing wall
	// post: Robot one past last section of wall, beepers dropped along wall
	public void plantASide()
	{
		while (!frontIsClear())
		{
			putBeeper();
			turnLeft();
			move();
			turnRight();
		}
	}

	// pre: Robot holding all beepers, one street south of rectangle
	// post: Robot next to southern-most section of west side of rectangle
	public void findRectangle()
	{
		move();
		turnRight();
		goToWall();
	}

	// pre: Robot facing north, a pile somewhere above
	// post: Robot on pile of beepers
	public void findThePile()
	{
		while (!nextToABeeper())
		{
			move();
		}
	}
}