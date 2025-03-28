package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();

        options.addOption("i", true, "maze file to read");
        options.addOption("p", true, "path to validate");
        options.addOption("l", false, "left hand rule");

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            String path = cmd.getOptionValue("p");
            String inputFile = cmd.getOptionValue("i");
            boolean leftHand = cmd.hasOption("l");  // Check if left-hand rule is selected

            logger.info("**** Reading the maze from file " + inputFile);

            Maze maze = new Maze(inputFile);

            if (path != null) { // if path is provided, validate it
                String newPath = path.replaceAll(" ", "");
                Path pathToValidate = new Path(maze);
                logger.info("Path to validate: " + newPath);
                if (pathToValidate.validatePath(newPath)) {
                    System.out.println("Correct path");
                } else {
                    System.out.println("Incorrect path");
                }
            } else { // otherwise, find the path
                Path pathToPrint = new Path(maze);
                List<Move> foundPath;

                if (leftHand) {
                    LeftHand pathToFind = new LeftHand(maze);
                    logger.info("**** Using left-hand rule to solve the maze");
                    foundPath = pathToFind.solveMaze();
                } else {
                    RightHand pathToFind = new RightHand(maze);
                    logger.info("**** Using right-hand rule to solve the maze");
                    foundPath = pathToFind.solveMaze();
                }

                logger.info("**** Computing path");
                System.out.println(pathToPrint.factorizedPath(foundPath));
                logger.info("** End of MazeRunner");
            }

        } catch (Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
            logger.error("Exception: ", e);
        }
    }
}
