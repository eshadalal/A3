package ca.mcmaster.se2aa4.mazerunner; 

public class TurnAroundCommand implements MoveCommand {
    private MazeSolver mazeSolver;

    public TurnAroundCommand(MazeSolver mazeSolver) {
        this.mazeSolver = mazeSolver;
    }

    @Override
    public void execute() {
        try {
            mazeSolver.turnAround();
        } catch (Exception e) {
        }
    }
}
