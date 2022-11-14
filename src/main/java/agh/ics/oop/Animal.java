package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement  {

    private MapDirection direction=MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<IPositionChangeObserver>();
    Animal(IWorldMap map){
        this.map=map;
    }
    Animal(IWorldMap map, Vector2d initialPosition){
        this.map=map;
        this.position=initialPosition;
    }
    public Vector2d getPosition() {
        return this.position;
    }
    public String getA(){
        return position+" "+direction;
    }
    public String toString(){
        return switch(direction) {
            case NORTH -> "N";
            case EAST -> "E";
            case WEST -> "W";
            case SOUTH -> "S";
        };
    }
    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }
    public void move(MoveDirection direction){
        if(direction==MoveDirection.RIGHT){
            this.direction=this.direction.next();
        } else if (direction==MoveDirection.LEFT) {
            this.direction=this.direction.previous();
        }
        else if (direction==MoveDirection.FORWARD) {
            Vector2d temp=this.direction.toUnitVector();
            Vector2d beforeTest=this.position.add(temp);
            if (map.canMoveTo(beforeTest)) {
                positionChanged(this.position,beforeTest);
                this.position=beforeTest;
            }
        }
        else if (direction==MoveDirection.BACKWARD) {
            Vector2d temp=this.direction.toUnitVector();
            Vector2d beforeTest=this.position.subtract(temp);
            if (map.canMoveTo(beforeTest)) {
                positionChanged(this.position,beforeTest);
                this.position=beforeTest;
            }
        }
    }
    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }
    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver Observer: this.observers) {
            Observer.positionChanged(oldPosition,newPosition);
        }
    }
}
