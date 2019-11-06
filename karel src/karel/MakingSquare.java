package karel;

import kareltherobot.*;

// This robot task is from page 11 in the text
public class MakingSquare implements Directions
{

	public static void main(String[] args)
	{
		// World file (leave out the readWorld line if you just want a blank world)
		World.readWorld("WorldFiles/fig1-4b.kwld");
		World.setVisible(true);

		UrRobot karel = new UrRobot(1, 1, East, 0);
		World.setDelay(15);
		karel.pickBeeper();
		karel.move();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft();
		karel.move();
		karel.pickBeeper();
		karel.turnLeft();
		karel.move();
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft();
		karel.move();
		karel.pickBeeper();
		karel.turnLeft();
		karel.move();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.putBeeper();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.move();
		karel.putBeeper();
		karel.move();
		karel.turnOff();
	}

}