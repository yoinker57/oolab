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

    public void move(MoveDirection dir) {
        if (dir != null) {
            switch (dir) {
                case RIGHT:
                    direction = direction.next();
                    break;
                case LEFT:
                    direction = direction.previous();
                    break;
                case FORWARD:
                    if (position.add(direction.toUnitVector()).precedes(new Vector2d(4, 4)) && position.add(direction.toUnitVector()).follows(new Vector2d(0, 0))) {
                        position = position.add(direction.toUnitVector());
                    }
                    break;
                case BACKWARD:
                    if (position.subtract(direction.toUnitVector()).follows(new Vector2d(0, 0)) && position.subtract(direction.toUnitVector()).precedes(new Vector2d(4, 4))) {
                        position = position.subtract(direction.toUnitVector());
                    }
                    break;
            }
        }
    }
}
