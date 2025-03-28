package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

public class RightHand extends MazeSolver {

    public RightHand(Maze mazeToSolve) {
        super(mazeToSolve);
    }

    public List<Move> findPath() throws Exception {
        int exitColumn = mazeToSolve.getExitColumn();
        int exitRow = mazeToSolve.getExitRow();

        MoveCommand turnRight = new TurnRightCommand(this);
        MoveCommand moveForward = new MoveForwardCommand(this);
        MoveCommand turnLeft = new TurnLeftCommand(this);
        MoveCommand turnAround = new TurnAroundCommand(this);

        while (currentPosition.getRow() != exitRow || currentPosition.getColumn() != exitColumn) { // while not at exit
            // try turning right first
            turnRight.execute();  // Execute turn right

            Position nextPosition = currentPosition.getNextPosition(currentDirection.getCurrentDirection());
            
            // if right is valid, move forward
            if (mazeToSolve.validateMove(nextPosition.getRow(), nextPosition.getColumn())) {
                movesMade.add(new Move('R'));
                movesMade.add(new Move('F'));
                moveForward.execute(); // Execute move forward

            } else {
                turnLeft.execute(); // come back to original direction

                // if right is invalid, try moving forward
                nextPosition = currentPosition.getNextPosition(currentDirection.getCurrentDirection());
                
                if (mazeToSolve.validateMove(nextPosition.getRow(), nextPosition.getColumn())) {
                    movesMade.add(new Move('F'));
                    moveForward.execute(); // Execute move forward

                } else {
                    turnLeft.execute(); // if forward is invalid, try to turn left and move forward

                    nextPosition = currentPosition.getNextPosition(currentDirection.getCurrentDirection());

                    if (mazeToSolve.validateMove(nextPosition.getRow(), nextPosition.getColumn())) {
                        movesMade.add(new Move('L'));
                        movesMade.add(new Move('F'));
                        moveForward.execute(); // Execute move forward

                    } else { // otherwise, turn around - entered dead end
                        
                        turnRight.execute(); // come back to original direction 
                        turnAround.execute(); // Execute turn around
                        movesMade.add(new Move('R'));
                        movesMade.add(new Move('R'));
                    }
                }
            }

            if (currentPosition.getRow() == exitRow && currentPosition.getColumn() == exitColumn) { // if exit is reached
                break; // exit the loop if the exit point is reached
            }
        }

        return movesMade; 
    }

}

