package ca.mcmaster.se2aa4.mazerunner; 

public class TurnRightCommand implements MoveCommand {
    private MazeSolver mazeSolver;

    public TurnRightCommand(MazeSolver mazeSolver) {
        this.mazeSolver = mazeSolver;
    }

    @Override
    public void execute() {
        try {
            mazeSolver.turnRight();
        } catch (Exception e) {
        }
    }
}
