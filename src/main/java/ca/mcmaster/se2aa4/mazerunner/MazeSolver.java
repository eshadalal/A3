package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public abstract class MazeSolver {

    protected Maze mazeToSolve;
    protected Position currentPosition;
    protected Direction currentDirection;
    protected List<Move> movesMade;

    public MazeSolver(Maze mazeToSolve) {
        this.mazeToSolve = mazeToSolve;
        this.movesMade = new ArrayList<>();
        this.currentPosition = new Position(mazeToSolve.getEntryRow(), mazeToSolve.getEntryColumn());
        this.currentDirection = new Direction(mazeToSolve.getEntryRow(), mazeToSolve.getEntryColumn(), Direction.Directions.EAST);
    }

    public List<Move> solveMaze() throws Exception {
        while (!isAtExit()) {
            if (canMoveForward()) {
                moveForward();
            } 
            else if (canTurnRight()) {
                turnRight();
            } 
            else if (canTurnLeft()) {
                turnLeft();
            } 
            else {
                turnAround();
            }
        }
        return getMoves();
    }
    
    protected boolean canTurnRight() throws Exception {
        Position nextPosition = currentPosition.getNextPosition(currentDirection.turnRight());
        return mazeToSolve.validateMove(nextPosition.getRow(), nextPosition.getColumn());
    }

    protected boolean canMoveForward() throws Exception {
        Position nextPosition = currentPosition.getNextPosition(currentDirection.getCurrentDirection());
        return mazeToSolve.validateMove(nextPosition.getRow(), nextPosition.getColumn());
    }

    protected boolean canTurnLeft() throws Exception {
        Position nextPosition = currentPosition.getNextPosition(currentDirection.turnLeft());
        return mazeToSolve.validateMove(nextPosition.getRow(), nextPosition.getColumn());
    }

    protected boolean isAtExit() {
        return currentPosition.getRow() == mazeToSolve.getExitRow() && currentPosition.getColumn() == mazeToSolve.getExitColumn();
    }

    protected void turnRight() throws Exception {
        currentDirection.changeDirection("R");
    }

    protected void turnLeft() throws Exception {
        currentDirection.changeDirection("L");
    }

    protected void moveForward() throws Exception {
        Position nextPosition = currentPosition.getNextPosition(currentDirection.getCurrentDirection());
        if (mazeToSolve.validateMove(nextPosition.getRow(), nextPosition.getColumn())) {
            currentPosition = nextPosition;
        }
    }

    protected void turnAround() throws Exception {
        currentDirection.changeDirection("R");
        currentDirection.changeDirection("R");
    }

    protected List<Move> getMoves() { 
        return movesMade;
    }
}
