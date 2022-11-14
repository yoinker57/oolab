package agh.ics.oop;


public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        OptionParser optionParser=new OptionParser();
        MoveDirection[] directions=optionParser.parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
        IWorldMap map=new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);
        System.out.println("system zakończył działanie");

    }
    public static void run(MoveDirection[] args, Animal animal){
        for(MoveDirection argument : args){
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };
            animal.move(argument);
            System.out.println(message);
            System.out.println(animal);
        }
    }
}
