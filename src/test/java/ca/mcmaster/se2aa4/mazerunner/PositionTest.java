package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test; 

public class PositionTest {

    @Test
    public void testGetRow() {
        Position position = new Position(4, 4);
        assertEquals(4, position.getRow());
    }

    @Test
    public void testGetColumn() {
        Position position = new Position(4, 6);
        assertEquals(6, position.getColumn());
    }

    @Test
    public void testGetNextPositionEast() throws Exception {
        Position position = new Position(4, 4);
        Position newPosition = position.getNextPosition(Direction.Directions.EAST);
        assertEquals(4, newPosition.getRow());
        assertEquals(5, newPosition.getColumn());
    }

    @Test
    public void testGetNextPositionNorth() throws Exception {
        Position position = new Position(1, 0);
        Position newPosition = position.getNextPosition(Direction.Directions.NORTH);
        assertEquals(0, newPosition.getRow());
        assertEquals(0, newPosition.getColumn());
    }

    @Test
    public void testGetNextPositionOnEdge() throws Exception {
        Position position = new Position(0, 0);
        Position newPosition = position.getNextPosition(Direction.Directions.NORTH); // Should throw exception
    }

    @Test
    public void testGetNextPositionSouth() throws Exception {
        Position position = new Position(1, 1);
        Position newPosition = position.getNextPosition(Direction.Directions.SOUTH);
        assertEquals(2, newPosition.getRow());
        assertEquals(1, newPosition.getColumn());
    }

    @Test
    public void testGetNextPositionWest() throws Exception {
        Position position = new Position(3, 6);
        Position newPosition = position.getNextPosition(Direction.Directions.WEST);
        assertEquals(3, newPosition.getRow());
        assertEquals(5, newPosition.getColumn());
    }


    



}