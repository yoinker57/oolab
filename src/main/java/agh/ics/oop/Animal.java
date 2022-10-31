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
        Vector2d ogr1 = new Vector2d(0,0);
        Vector2d ogr2 = new Vector2d(4,4);
        if (dir != null) {
            switch (dir) {
                case RIGHT:
                    direction = direction.next();
                    break;
                case LEFT:
                    direction = direction.previous();
                    break;
                case FORWARD:
                    if (position.add(direction.toUnitVector()).precedes(ogr2) && position.add(direction.toUnitVector()).follows(ogr1)) {
                        position = position.add(direction.toUnitVector());
                    }
                    break;
                case BACKWARD:
                    if (position.subtract(direction.toUnitVector()).follows(ogr1) && position.subtract(direction.toUnitVector()).precedes(ogr2)) {
                        position = position.subtract(direction.toUnitVector());
                    }
                    break;
            }
        }
    }
}
