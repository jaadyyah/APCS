package karel;

import kareltherobot.*;
import kareltherobot.Directions.Direction;

public class Bowling_kid extends UrRobot
{
	public Bowling_kid(int street, int avenue, Direction direction, int beepers)
	{
		super(street, avenue, direction, beepers);
	}

// battle plan: take each row by storm, have each method be a row, 
// NTS need to watch where karel ends up 
	public void turnRight()
	{
		super.turnLeft();
		super.turnLeft();
		super.turnLeft();
	}

	public void rowOne()
	{
		super.move();
		super.putBeeper();
	}

	public void rowTwo()
	{
		super.turnLeft();
		super.move();
		turnRight();
		super.move();
		super.putBeeper();
		turnRight();
		super.move();
		super.move();
		super.putBeeper();
	}

	public void rowThree()
	{
		super.move();
		super.turnLeft();
		super.move();
		super.putBeeper();
		super.turnLeft();
		super.move();
		super.move();
		super.putBeeper();
		super.move();
		super.move();
		super.putBeeper();
	}

	public void rowFour()
	{
		super.move();
		turnRight();
		super.move();
		super.putBeeper();
		turnRight();
		super.move();
		super.move();
		super.putBeeper();
		super.move();
		super.move();
		super.putBeeper();
		super.move();
		super.move();
		super.putBeeper();
	}

	public void lastLeg()
	{
		super.turnLeft();
		super.move();
		super.turnLeft();
		super.move();
		super.move();
		super.move();
		super.turnLeft();
		super.turnOff();
	}

	public static void main(String[] args)
	{
// TODO Auto-generated method stub
		World.setVisible(true);

		Bowling_kid karel = new Bowling_kid(1, 5, North, 10);
		karel.rowOne();
		karel.rowTwo();
		karel.rowThree();
		karel.rowFour();
// thought about not making the last part into a method, idk it would work the same way but i guess it would look better 
		karel.lastLeg();
	}

}