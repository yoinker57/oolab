package agh.ics.oop;

import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private final int width;
    private final int height;
    private Vector2d lowerLeft;
    private Vector2d upperRight;
    public RectangularMap(int width,int height){
        this.width = width;
        this.height = height;
        this.lowerLeft = new Vector2d(0, 0);
        this.upperRight = new Vector2d(width-1, height-1);
    }
    @Override
    public String toString() {
        return this.visualize.draw(new Vector2d(0,0),new Vector2d(this.width,this.height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(upperRight) && position.follows(lowerLeft) && super.canMoveTo(position);
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

    public List<Animal> getAnimals() {
        return super.getAnimals();
    }
}
