package ca.mcmaster.se2aa4.mazerunner; 

public class TurnLeftCommand implements MoveCommand {
    private MazeSolver mazeSolver;

    public TurnLeftCommand(MazeSolver mazeSolver) {
        this.mazeSolver = mazeSolver;
    }

    @Override
    public void execute() {
        try {
            mazeSolver.turnLeft();
        } catch (Exception e) {
        }
    }
}
