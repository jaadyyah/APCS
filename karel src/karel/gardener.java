package karel;

import kareltherobot.*;

public class gardener extends UrRobot
{
public gardener(int street, int avenue, Direction direction, int beepers)
{
super(street, avenue, direction, beepers);
}

public void turnRight()
{
	super.turnLeft();
	super.turnLeft();
	super.turnLeft();
}

public void movePutBeeper()
{
	super.move();
	super.putBeeper();
}

public void movePutTimes3() // added this because copying and pasting movePutBeeper is annoying 
// stupid name I'm not really sure what to call it lol
{
	movePutBeeper();
	movePutBeeper();
	movePutBeeper();
}

public void southWestQuad()
{
	super.putBeeper();
	movePutTimes3();
	super.turnLeft();
	movePutTimes3();
}

public void northWestQuad()
{
	movePutBeeper();
	turnRight();
	movePutTimes3();
	super.turnLeft();
	movePutTimes3();
}

public void northEastQuad()
{
	movePutBeeper();
	turnRight();
	movePutTimes3();
	super.turnLeft();
	movePutTimes3();
}

public void southEastQuad()
{
	movePutBeeper();
	turnRight();
	movePutTimes3();
	super.turnLeft();
	movePutTimes3();
}



public static void main(String[] args) 
{
	// TODO Auto-generated method stub
World.readWorld("WorldFiles/fig3-8.kwld");
World.setVisible(true);

gardener karel = new gardener(2,2,South,28);
karel.turnLeft();
karel.move();
karel.move();
karel.move();
karel.turnLeft();
karel.southWestQuad();
karel.turnRight();
karel.northWestQuad();
karel.turnRight();
karel.northEastQuad();
karel.turnRight();
karel.southEastQuad();
karel.turnRight();
karel.move();
karel.move();
karel.move();
karel.move();
karel.turnLeft();
karel.turnOff();
}

}
