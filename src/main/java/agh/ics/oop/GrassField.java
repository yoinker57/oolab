package agh.ics.oop;
import java.lang.Math;
import java.util.Set;

public class GrassField extends AbstractWorldMap {
    private final int maxX;
    private final int maxY;

    public GrassField(int grass){
        this.maxX = (int)Math.sqrt(grass*10);
        this.maxY = (int)Math.sqrt(grass*10);
        while (grasses.size() < grass) {
            int randx = (int)(Math.random()*(this.maxX +1));
            int randy = (int)(Math.random()*(this.maxY +1));
            Vector2d grassPosition = new Vector2d(randx, randy);
            Grass grasss = new Grass(new Vector2d(randx,randy));
            if (objectAt(grassPosition) == null) {
                this.grasses.put(grasss.getPosition(),grasss);
                mapBoundary.put(grasss);
            }

        }
    }
    @Override
    public String toString() {
        this.mapBoundary.sortuj();
        int x = this.mapBoundary.X_el.get(0).getPosition().x;
        int y = this.mapBoundary.Y_el.get(0).getPosition().y;
        Vector2d vectorL = new Vector2d(x,y);
        x = this.mapBoundary.X_el.get(this.mapBoundary.X_el.size()-1).getPosition().x;
        y = this.mapBoundary.Y_el.get(this.mapBoundary.Y_el.size()-1).getPosition().y;
        Vector2d vectorR = new Vector2d(x,y);
        return this.visualize.draw(vectorL,vectorR);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position);
    }

    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object o = super.objectAt(position);
        if (o != null) {
            return o;
        }
        return grasses.get(position);
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return grasses.containsKey(position) || super.isOccupied(position);
    }
}
