package karel;

import kareltherobot.*;

public class Traveller extends UrRobot
{
public Traveller(int street, int avenue, Direction direction, int beepers)
{
super(street, avenue, direction, beepers);
}

public void moveMile()
{
// remembering that a mile is 8 blocks long
	super.move();
	super.move();
	super.move();
	super.move();
	super.move();
	super.move();
	super.move();
	super.move();
}

public void moveBackward()
{
// which moves Karel one block backward, but leaves it facing the same direction
// its always going to face EAST 
// left, left, move, left, left to be put in original position
	super.turnLeft();
	super.turnLeft();
	super.move();
	super.turnLeft();
	super.turnLeft();
// this method works fine but it doesn't show it on the actual grid but it does show it in the RobotID 
}

public void moveKiloMile()
{
// which moves Karel 1000 miles forward – use your brain, NOT brute force!
// you will probably want to include some additional methods in order to do this
// CAN'T USE LOOPS haven't learned it anyways but I could always find out ;_;
// moveEightHundredMiles ten times will get me to 8,000
	moveEightHundredMiles(); // GOOD THING COPY PASTE IS A THING 
	moveEightHundredMiles();
	moveEightHundredMiles();
	moveEightHundredMiles();
	moveEightHundredMiles();
	moveEightHundredMiles();
	moveEightHundredMiles();
	moveEightHundredMiles();
	moveEightHundredMiles();
	moveEightHundredMiles();
}

private void moveTenMiles()
{ 
// this is making the mile method into 10 moves so its easier to divide out
// 8 x 10 = 80
// 80 x 10 = 800 
// need to make a new method. If I make a moveTenMiles 10 times that would make it moveEightHundredMiles 
	moveMile(); // 8 moves 
	moveMile(); // 8 moves
	moveMile(); // 8 moves
	moveMile(); // 8 moves
	moveMile(); // 8 moves
	moveMile(); // 8 moves
	moveMile(); // 8 moves
	moveMile(); // 8 moves
	moveMile(); // 8 moves
	moveMile(); // 8 moves
}

private void moveEightHundredMiles()
{
// by putting 10 moveTenMiles I should have 800 miles 
	moveTenMiles();
	moveTenMiles();
	moveTenMiles();
	moveTenMiles();
	moveTenMiles();
	moveTenMiles();
	moveTenMiles();
	moveTenMiles();
	moveTenMiles();
	moveTenMiles();
}

public static void main(String[] args)
{
World.setVisible(true);
World.setDelay(0);

Traveller karel = new Traveller(2,2,East,0);
karel.moveBackward();
karel.moveMile();
karel.moveKiloMile();
}

}
// this is so ugly SORRY BUT HEY IT WORKS 