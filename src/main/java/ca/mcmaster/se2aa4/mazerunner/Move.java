package ca.mcmaster.se2aa4.mazerunner;

// class to handle each individual move 

public class Move {
    private char move;

    public Move(char move) {
        this.move = move;
    }

    public char getMove() {
        return move;
    }

    public void setMove(char move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return "" + move;  
    }

}
