package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PathValidationTest {

    @Test
    public void testValidPath() throws Exception {
        String mazeFilePath = "./examples/test.maz.txt";
        Maze maze = new Maze(mazeFilePath);
        Path path = new Path(maze);
        String validPath = "FRFLF"; 
        boolean result = path.validatePath(validPath);
        assertTrue(result); 
    }

    @Test
    public void testInvalidPath() throws Exception {
        String mazeFilePath = "./examples/test.maz.txt";
        Maze maze = new Maze(mazeFilePath);
        Path path = new Path(maze);
        String invalidPath = "F F R L"; 
        boolean result = path.validatePath(invalidPath);
        assertFalse(result); 
    }

    @Test
    public void testInvalidMove() throws Exception {
        String mazeFilePath = "./examples/test.maz.txt";
        Maze maze = new Maze(mazeFilePath);
        Path path = new Path(maze);
        String invalidPath = "F E"; 
        boolean result = path.validatePath(invalidPath);
        assertFalse(result); 
    }

    @Test
    public void testEmptyPath() throws Exception {
        String mazeFilePath = "./examples/test.maz.txt";
        Maze maze = new Maze(mazeFilePath);
        Path path = new Path(maze);
        String emptyPath = ""; 
        boolean result = path.validatePath(emptyPath); 
        assertFalse(result); 
    }

}