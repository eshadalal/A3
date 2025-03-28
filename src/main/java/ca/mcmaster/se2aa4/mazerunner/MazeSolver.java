package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MazeSolver {
    protected static final Logger logger = LogManager.getLogger();
    
    protected Maze mazeToSolve;
    protected Position currentPosition;
    protected Direction currentDirection;

    public MazeSolver(Maze mazeToSolve, Direction.Directions startDirection) {
        this.mazeToSolve = mazeToSolve;
        this.currentPosition = new Position(mazeToSolve.getEntryRow(), mazeToSolve.getEntryColumn());
        this.currentDirection = new Direction(mazeToSolve.getEntryRow(), mazeToSolve.getEntryColumn(), startDirection);
    }

    public final List<Move> solveMaze() throws Exception {
        int exitColumn = mazeToSolve.getExitColumn();
        int exitRow = mazeToSolve.getExitRow();
        List<Move> movesMade = new ArrayList<>();

        while (!isAtExit(exitRow, exitColumn)) {
            logger.info("Current Position: (" + currentPosition.getRow() + ", " + currentPosition.getColumn() + ")");
            makeMove(movesMade);
        }

        logger.info("Exit reached: (" + currentPosition.getRow() + ", " + currentPosition.getColumn() + ")");
        return movesMade;
    }

    private boolean isAtExit(int exitRow, int exitColumn) {
        return currentPosition.getRow() == exitRow && currentPosition.getColumn() == exitColumn;
    }

    protected abstract void makeMove(List<Move> movesMade) throws Exception;

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

}


