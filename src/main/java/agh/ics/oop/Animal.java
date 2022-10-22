package agh.ics.oop;

public class Animal {
    private World.MapDirection direction = World.MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public String toString(){
        return "(" + this.position.toString() + ", " + this.direction + ")";
    }
    public boolean isAt(Vector2d position){
        if (this.position == position)
            return true;
        return this.position.x == position.x & this.position.y == position.y;
    }

    public void move(Direction direction){
        switch (direction){
            case RIGHT -> this.direction.next();
            case LEFT -> this.direction.previous();
        };
    }
}
