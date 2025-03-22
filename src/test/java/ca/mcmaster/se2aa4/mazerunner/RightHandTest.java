// package ca.mcmaster.se2aa4.mazerunner;

// import java.util.List;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import org.junit.jupiter.api.Test;

// public class RightHandTest {

//     @Test
//     public void testFindPath() throws Exception {
//         String mazeFilePath = "./examples/test.maz.txt";
//         Maze maze = new Maze(mazeFilePath);
//         RightHand rightHand = new RightHand(maze);
//         List<Move> path = rightHand.findPath();

//         assertEquals('F', path.get(0).getMove());
//         assertEquals('R', path.get(1).getMove());
//         assertEquals('F', path.get(2).getMove());
//         assertEquals('L', path.get(3).getMove());
//         assertEquals('F', path.get(4).getMove());
//     }

//     @Test
//     public void testUnsolvableMaze() throws Exception {
//         String mazeFilePath = "./examples/unsolvable.maz.txt";
//         Maze unsolvableMaze = new Maze(mazeFilePath);
//         RightHand rightHand = new RightHand(unsolvableMaze);
//         List<Move> noPath = rightHand.findPath();

//         assertTrue(noPath.isEmpty());
//     }
// }
