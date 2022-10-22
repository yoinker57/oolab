package agh.ics.oop;


public class World {
    public World() {
    }
    public static void main(String[] args) {
        Animal kazio = new Animal();
        MoveDirection[] directions = OptionsParser.parse(args);
        for (MoveDirection direction : directions){
            kazio.move(direction);
        }
        System.out.println(kazio);

    }

enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String toString(){
        return switch (this) {
            case NORTH -> "Polnoc";
            case SOUTH -> "Poludnie";
            case EAST -> "Wschod";
            case WEST -> "Zachod";
        };
    }
    public MapDirection next(){
        return switch (this){
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }
    public MapDirection previous(){
        return switch (this){
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
    }

    public Vector2d toUnitVector(){
        return switch (this){
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
        };
    }
}}


//String[] test1tab = {"r", "right", "forward", "left", "forward", "f", "r"}
//Animal animal = new Animal();
//    MoveDirection[] directions = OptionsParser.parse(test1tab);
//        for (MoveDirection direction : directions){
//                animal.move(direction);
//                }
//                assertEquals(animal, "((4,1) Poludnie)");
