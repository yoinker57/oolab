package agh.ics.oop;

public class World {
    public World() {
    }

    public static void main(String[] args) {
        System.out.println("system wystartował");
        Direction[] arguments = new Direction[args.length];
        for (int i = 0; i < args.length; i++){
            Direction message = switch (args[i]) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "l" -> Direction.LEFT;
                case "r" -> Direction.RIGHT;
                default -> Direction.NOMOVE;
            };
            arguments[i] = message;
        }
        run(arguments);
        System.out.println("system zakończył działanie");
    }

    public static void run(Direction[] args) {
        for (Direction i: args){
            String message = switch (i){
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak skręca w lewo";
                case RIGHT -> "Zwierzak skręca w prawo";
                default -> "";
            };
            System.out.println(message);
        }
    }
}

