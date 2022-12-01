package agh.ics.oop;
import java.lang.Math;
import java.util.Set;

public class GrassField extends AbstractWorldMap {
    private final int rangex;
    private final int rangey;

    public GrassField(int grass){
        this.rangex = (int)Math.sqrt(grass*10);
        this.rangey = (int)Math.sqrt(grass*10);
        for (int i = 0; i < grass; i++){
            int randx = (int)(Math.random()*(this.rangex+1));
            int randy = (int)(Math.random()*(this.rangey+1));
            Vector2d v = new Vector2d(randx,randy);
            Grass trawka = new Grass(v);
            this.grasses_map.put(v,trawka);
            this.bound.put(trawka);
        }
    }
    @Override
    public String toString() {
        this.bound.sortowanko();
//        System.out.println("XD");
//        for (AbstractWorldMapElement el: this.bound.X_el){
//            System.out.println(el.getPosition());
//        }
        int x = this.bound.X_el.get(0).getPosition().x;
        int y = this.bound.Y_el.get(0).getPosition().y;
        Vector2d vectorL = new Vector2d(x,y);
        x = this.bound.X_el.get(this.bound.X_el.size()-1).getPosition().x;
        y = this.bound.Y_el.get(this.bound.Y_el.size()-1).getPosition().y;
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
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position);
    }
    @Override
    public Object objectAt(Vector2d position) {
        return super.objectAt(position);
    }
}
