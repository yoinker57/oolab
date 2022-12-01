package agh.ics.oop;

import java.util.Arrays;

public class OptionParser {
    public MoveDirection[] parse(String[] array){
        int counter = 0;
        MoveDirection[] movedirections = new MoveDirection[array.length];
        for (String argument : array){
            switch (argument) {
                case "f","forward" -> {
                    movedirections[counter] = MoveDirection.FORWARD;
                    counter++;
                }
                case "b","backward" -> {
                    movedirections[counter] = MoveDirection.BACKWARD;
                    counter++;
                }
                case "l","left" -> {
                    movedirections[counter] = MoveDirection.LEFT;
                    counter++;
                }
                case "r","right" -> {
                    movedirections[counter] = MoveDirection.RIGHT;
                    counter++;
                }
                default -> throw new IllegalArgumentException(argument + " is not legal move specification");
            }
        }
        return Arrays.copyOfRange(movedirections, 0, counter);
    }
}
