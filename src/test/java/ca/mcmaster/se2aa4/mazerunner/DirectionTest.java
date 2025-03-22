package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test; 

public class DirectionTest {

    @Test
    public void testTurnLeftFromNorth() {
        Direction direction = new Direction(0, 0, Direction.Directions.NORTH);
        direction.turnLeft();
        assertEquals(Direction.Directions.WEST, direction.getCurrentDirection());
    }

    @Test
    public void testTurnLeftFromEast() {
        Direction direction = new Direction(0, 0, Direction.Directions.EAST);
        direction.turnLeft();
        assertEquals(Direction.Directions.NORTH, direction.getCurrentDirection());
    }

    @Test
    public void testTurnLeftFromSouth() {
        Direction direction = new Direction(0, 0, Direction.Directions.SOUTH);
        direction.turnLeft();
        assertEquals(Direction.Directions.EAST, direction.getCurrentDirection());
    }

    @Test
    public void testTurnLeftFromWest() {
        Direction direction = new Direction(0, 0, Direction.Directions.WEST);
        direction.turnLeft();
        assertEquals(Direction.Directions.SOUTH, direction.getCurrentDirection());
    }

    @Test
    public void testGetDirection() {
        Direction direction = new Direction(0, 0, Direction.Directions.NORTH);
        assertEquals(Direction.Directions.NORTH, direction.getCurrentDirection());
    }

}
