package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

public class LeftHand extends MazeSolver {

    public LeftHand(Maze mazeToSolve) {
        super(mazeToSolve); 
    }

    public List<Move> findPath() throws Exception {
        int exitColumn = mazeToSolve.getExitColumn();
        int exitRow = mazeToSolve.getExitRow();

        MoveCommand turnRight = new TurnRightCommand(this);
        MoveCommand moveForward = new MoveForwardCommand(this);
        MoveCommand turnLeft = new TurnLeftCommand(this);
        MoveCommand turnAround = new TurnAroundCommand(this);

        while (currentPosition.getRow() != exitRow || currentPosition.getColumn() != exitColumn) {
            // Turn left and check if forward move is possible
            turnLeft.execute();
            Position nextPosition = currentPosition.getNextPosition(currentDirection.getCurrentDirection());
            // call overridden method from this class can turn left and add these extra steps to the method
            if (mazeToSolve.validateMove(nextPosition.getRow(), nextPosition.getColumn())) {
                movesMade.add(new Move('L'));
                movesMade.add(new Move('F'));
                moveForward.execute();
            } else {
                // If left is blocked, turn right and try to move forward
                turnRight.execute();
                nextPosition = currentPosition.getNextPosition(currentDirection.getCurrentDirection());

                if (mazeToSolve.validateMove(nextPosition.getRow(), nextPosition.getColumn())) {
                    movesMade.add(new Move('R'));
                    movesMade.add(new Move('F'));
                    moveForward.execute();
                } else {
                    // If forward and right are blocked, turn around (dead end)
                    turnLeft.execute(); // Return to original direction
                    turnAround.execute();
                    movesMade.add(new Move('R'));
                    movesMade.add(new Move('R'));
                }
            }
        }

        return movesMade;  
    }
}


// override protected methods from mazesolver and call them here same for right hand
