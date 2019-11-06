package karel;

import kareltherobot.*;

public class PSet_S2B implements Directions
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		World.readWorld("WorldFiles/fig2-9.kwld");
		World.setVisible(true);
		
		UrRobot karel = new UrRobot(1,2,East,1);
		World.setDelay(4);
		// Your instructions to complete this task should go below this line
		karel.move();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft(); //NTS 3 turnLefts are a right can I make a class or something to define that?
		karel.move();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft(); //First half of the structure before putting beeper down
		karel.move();
		karel.putBeeper();
		karel.move();
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft(); //finished the top level set to go down
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.move();
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft(); //Complete
		karel.turnOff();
		
	}

}
