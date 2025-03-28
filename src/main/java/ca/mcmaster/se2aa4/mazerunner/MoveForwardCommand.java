package ca.mcmaster.se2aa4.mazerunner; 

public class MoveForwardCommand implements MoveCommand {
    private MazeSolver mazeSolver;

    public MoveForwardCommand(MazeSolver mazeSolver) {
        this.mazeSolver = mazeSolver;
    }

    @Override
    public void execute() {
        try {
            mazeSolver.moveForward();
        } catch (Exception e) {
        }
    }
}
