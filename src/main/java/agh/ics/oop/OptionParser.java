package agh.ics.oop;

import java.util.Arrays;

public class OptionParser {
    public MoveDirection[] parse(String[] args) throws IllegalArgumentException{
        int counter=0;
        MoveDirection[] direction=new MoveDirection[args.length];
        for(String argument : args) {
            switch (argument) {
                case "f", "forward" -> {
                    direction[counter] = MoveDirection.FORWARD;
                    counter++;
                }
                case "b", "backward" -> {
                    direction[counter] = MoveDirection.BACKWARD;
                    counter++;
                }
                case "r", "right" -> {
                    direction[counter] = MoveDirection.RIGHT;
                    counter++;
                }
                case "l", "left" -> {
                    direction[counter] = MoveDirection.LEFT;
                    counter++;
                }
                default -> {
                    throw new IllegalArgumentException(argument + " is not legal move specification");
                }
            }
        }
        return Arrays.copyOfRange(direction,0,counter);
    }
}
