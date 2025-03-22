package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MazeTest {

    @Test
    public void testGetEntry() throws Exception {
        String mazeFilePath = "./examples/test.maz.txt";
        Maze maze = new Maze(mazeFilePath);
        assertEquals(1, maze.getEntryRow()); 
        assertEquals(0, maze.getEntryColumn());
    }

    @Test
    public void testGetExit() throws Exception {
        String mazeFilePath = "./examples/test.maz.txt";
        Maze maze = new Maze(mazeFilePath);
        assertEquals(2, maze.getExitRow()); 
        assertEquals(2, maze.getExitColumn());
    }

    @Test
    public void testValidateValidMove() throws Exception {
        String mazeFilePath = "./examples/test.maz.txt";
        Maze maze = new Maze(mazeFilePath);
        assertTrue(maze.validateMove(1, 0)); 
    }

    @Test
    public void testValidateInvalidMove() throws Exception {
        String mazeFilePath = "./examples/test.maz.txt";
        Maze maze = new Maze(mazeFilePath);
        assertFalse(maze.validateMove(2, 0));
        assertFalse(maze.validateMove(0, 3)); 
    }
}
