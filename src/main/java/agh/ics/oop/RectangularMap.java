package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;
    public RectangularMap(int width,int height){
        this.width = width;
        this.height = height;
    }
    @Override
    public String toString() {
        return this.visualize.draw(new Vector2d(0,0),new Vector2d(this.width,this.height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.x <= this.width && position.y <= this.height && position.x >= 0 && position.y >= 0) {
            return super.canMoveTo(position);
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if(position.x <= this.width && position.y <= this.height && position.x >= 0 && position.y >= 0) {
            return super.place(animal);
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return super.objectAt(position);
    }

}
