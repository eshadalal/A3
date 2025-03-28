package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

public class LeftHand extends MazeSolver {

    public LeftHand(Maze mazeToSolve) {
        super(mazeToSolve, Direction.Directions.EAST);
    }

    @Override
    protected void makeMove(List<Move> movesMade) throws Exception {
        MoveCommand turnLeft = new TurnLeftCommand(this);
        MoveCommand moveForward = new MoveForwardCommand(this);
        MoveCommand turnRight = new TurnRightCommand(this);
        MoveCommand turnAround = new TurnAroundCommand(this);

        // Try turning left first
        turnLeft.execute();
        if (canMoveForward()) {
            movesMade.add(new Move('L'));
            moveForward.execute();
            movesMade.add(new Move('F'));
        } else {
            // If left is blocked, revert direction and try moving forward
            turnRight.execute();  // Come back to the original direction
            if (canMoveForward()) {
                movesMade.add(new Move('F'));
                moveForward.execute();
            } else {
                // If forward is blocked, turn right again and move forward
                turnRight.execute();  // Turn right to find an alternate path
                if (canMoveForward()) {
                    movesMade.add(new Move('R'));
                    moveForward.execute();
                    movesMade.add(new Move('F'));
                } else { 
                    // If all directions are blocked, turn around
                    turnLeft.execute(); // come back to original direction
                    turnAround.execute();  // This simulates a dead-end situation
                    movesMade.add(new Move('R'));  // Turn around twice to handle the dead-end
                    movesMade.add(new Move('R'));
                }
            }
        }
    }
}

