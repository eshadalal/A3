package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LeftHandTest {

    private Maze maze;
    private LeftHand leftHandSolver;

    @Test
    public void testLeftHandSolverTinyMaze() throws Exception {
        maze = new Maze("./examples/tiny.maz.txt");
        leftHandSolver = new LeftHand(maze);

        List<Move> moves = leftHandSolver.solveMaze();

        assertNotNull(moves);
        assertFalse(moves.isEmpty());

        assertEquals("F", moves.get(0).toString());
        assertEquals("F", moves.get(1).toString());
        assertEquals("F", moves.get(2).toString());
        
        assertEquals("L", moves.get(3).toString());

        assertEquals("F", moves.get(4).toString());
        assertEquals("F", moves.get(5).toString());

        assertEquals("L", moves.get(6).toString());

        assertEquals("F", moves.get(7).toString());
        assertEquals("F", moves.get(8).toString());

        assertEquals("R", moves.get(9).toString());
        assertEquals("R", moves.get(10).toString());

        assertEquals("F", moves.get(11).toString());
        assertEquals("F", moves.get(12).toString());

        assertEquals("L", moves.get(13).toString());

        assertEquals("F", moves.get(14).toString());
        assertEquals("F", moves.get(15).toString());

        assertEquals("L", moves.get(16).toString());

        assertEquals("F", moves.get(17).toString());
        assertEquals("F", moves.get(18).toString());

        assertEquals("R", moves.get(19).toString());
        assertEquals("R", moves.get(20).toString());

        assertEquals("F", moves.get(21).toString());
        assertEquals("F", moves.get(22).toString());
        assertEquals("F", moves.get(23).toString());
        assertEquals("F", moves.get(24).toString());
        assertEquals("F", moves.get(25).toString());
    }

    @Test
    public void testLeftHandSolverTestMaze() throws Exception {
        maze = new Maze("./examples/test.maz.txt");
        leftHandSolver = new LeftHand(maze);

        List<Move> moves = leftHandSolver.solveMaze();

        assertNotNull(moves);
        assertFalse(moves.isEmpty());

        assertEquals("F", moves.get(0).toString());
        assertEquals("R", moves.get(1).toString());
        assertEquals("F", moves.get(2).toString());
        assertEquals("L", moves.get(3).toString());
        assertEquals("F", moves.get(4).toString());
        }

}

