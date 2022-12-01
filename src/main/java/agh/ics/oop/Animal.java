package agh.ics.oop;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement {
    private final IWorldMap map;
    private MapDirection direction = MapDirection.NORTH;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();
    public Animal(IWorldMap map,Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    @Override
    public String toString() {
        return switch(this.direction){
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
    }
    public void move(MoveDirection direction){
        Vector2d pos = this.position;
        MapDirection dir = this.direction;
        switch (direction){
            case RIGHT -> {
                this.direction = dir.next();
                positionChanged(this.position,this.position);
            }
            case LEFT -> {
                this.direction = dir.previous();
                positionChanged(this.position,this.position);
            }
            case FORWARD -> {
                Vector2d temp = pos.add(dir.toUnitVector());
                if(this.map.canMoveTo(temp)){
                    Vector2d actual_pos = this.position;
                    this.position = temp;
                    positionChanged(actual_pos,temp);

                }
            }
            case BACKWARD -> {
                Vector2d temp = pos.add(dir.toUnitVector().opposite());
                if(this.map.canMoveTo(temp)){
                    Vector2d actual_pos = this.position;
                    this.position = temp;
                    positionChanged(actual_pos,temp);
                }
            }
        }
    }
    public MapDirection getDirection() {
        return this.direction;
    }
    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }
    void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver Observer: this.observers) {
            Observer.positionChanged(oldPosition,newPosition);
        }
    }
    @Override
    public String getName(){
        return switch (this.direction) {
            case NORTH -> "up";
            case EAST -> "right";
            case SOUTH -> "down";
            case WEST -> "left";
        };
    }
}
