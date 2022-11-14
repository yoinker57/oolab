package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    protected List<Animal> animalsList = new ArrayList<>();
    protected Map<Vector2d, Animal> animals = new HashMap<>();

    protected Map<Vector2d, Grass> grasses = new HashMap<Vector2d, Grass>();

    protected final MapVisualizer visualize = new MapVisualizer(this);


    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!animals.containsKey(position));
    }

    @Override
    public boolean place(Animal animal) {
        if(this.animals.get(animal.getPosition()) != null){
            return false;
        }
        this.animalsList.add(animal);
        this.animals.put(animal.getPosition(),animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animals.get(position) != null || this.grasses.get(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(this.animals.get(position) != null){
            return this.animals.get(position);
        }
        if(this.grasses.get(position) != null){
            return this.grasses.get(position);
        }
        return null;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if(!newPosition.equals(oldPosition)) {
            Animal a = animals.remove(oldPosition);
            animals.put(newPosition, a);
        }
    }
    public List<Animal> getAnimals(){
        return this.animalsList;
    }
}
