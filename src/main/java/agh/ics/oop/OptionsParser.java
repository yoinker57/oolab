package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        MoveDirection[] result = new MoveDirection[args.length];
        int i = 0;
        for (String item : args){
            switch (item) {
                case "f", "forward" -> {
                    result[i] = MoveDirection.FORWARD;
                    i++;
                }
                case "b", "backward" -> {
                    result[i] = MoveDirection.BACKWARD;
                    i++;
                }
                case "l", "left" -> {
                    result[i] = MoveDirection.LEFT;
                    i++;
                }
                case "r", "right" -> {
                    result[i] = MoveDirection.RIGHT;
                    i++;
                }
                default -> {
                }
            }
        }

        return result;
    }
}
