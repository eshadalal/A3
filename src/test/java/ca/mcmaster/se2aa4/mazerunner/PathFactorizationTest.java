package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PathFactorizationTest {

    @Test
    public void testFactorizedPathMultipleMoves() throws Exception {

        String mazeFilePath = "./examples/test.maz.txt";
        Maze maze = new Maze(mazeFilePath);
        Path path = new Path(maze);
    
        List<Move> moves = new ArrayList<>();
        moves.add(new Move('F'));
        moves.add(new Move('F'));
        moves.add(new Move('F'));
        moves.add(new Move('L'));
        moves.add(new Move('F'));
        moves.add(new Move('F'));
        moves.add(new Move('R'));

        String resultPath = path.factorizedPath(moves);
        assertEquals("3F L 2F R", resultPath);
    }

    @Test
    public void testFactorizedPathOneMove() throws Exception {

        String mazeFilePath = "./examples/test.maz.txt";
        Maze maze = new Maze(mazeFilePath);
        Path path = new Path(maze);

        List<Move> moves = new ArrayList<>();
        moves.add(new Move('R'));

        String resultPath = path.factorizedPath(moves);
        assertEquals("R", resultPath);
    }

    @Test
    public void testFactorizedPathInvalidMove() throws Exception {
        
        String mazeFilePath = "./examples/test.maz.txt";
        Maze maze = new Maze(mazeFilePath);
        Path path = new Path(maze);

        List<Move> moves = new ArrayList<>();
        moves.add(new Move('F'));
        moves.add(new Move('E')); 

        path.factorizedPath(moves);
    }
}
