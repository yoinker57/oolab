package agh.ics.oop;

public class Animal {
    private World.MapDirection orientation = World.MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private static IWorldMap map;

    public Vector2d getPosition(){
        return position;
    }
    public World.MapDirection getOrientation() {
        return orientation;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    public void setOrientation(World.MapDirection orientation) {
        this.orientation = orientation;
    }

    public IWorldMap getMap() {
        return map;
    }

    public void setMap(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map) {
        Animal.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }


    public String toString(){
        return switch(orientation){
            case NORTH -> "N";
            case EAST -> "E";
            case WEST -> "W";
            case SOUTH -> "S";
        };
    }

    public boolean isAt(Vector2d position){
        return  this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        if (direction != null) {
            switch (direction) {
                case RIGHT:
                    orientation = orientation.next();
                    break;
                case LEFT:
                    orientation = orientation.previous();
                    break;
                case FORWARD:
                    if (map.canMoveTo(position.add(orientation.toUnitVector()))) {
                        position = position.add(orientation.toUnitVector());
                    }
                    break;
                case BACKWARD:
                    if (map.canMoveTo(position.subtract(orientation.toUnitVector()))) {
                        position = position.subtract(orientation.toUnitVector());
                    }
                    break;
            }
        }
    }
}
