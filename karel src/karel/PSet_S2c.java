package karel;

import kareltherobot.*;

public class PSet_S2c implements Directions
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		World.readWorld("WorldFiles/fig2-12.kwld");
		World.setVisible(true);
		
		UrRobot karel = new UrRobot(3,5,North,1);
		karel.turnLeft();
		karel.move();
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft();
		karel.move();
		karel.move();
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft();
		karel.move();
		karel.turnLeft();
		karel.turnLeft();
		karel.turnLeft();
		karel.turnOff(); // not too fast if you ask me but I tried LOL
	}

}
