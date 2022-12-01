package agh.ics.oop;

import java.util.Objects;

public class Vector2d {
    public int x;
    public int y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }
    boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
    }
    Vector2d upperRight(Vector2d other){
        int x_a,y_a;
        x_a = Math.max(this.x, other.x);
        y_a = Math.max(this.y, other.y);
        return new Vector2d(x_a,y_a);
    }
    Vector2d lowerLeft(Vector2d other){
        int x_a,y_a;
        x_a = Math.min(this.x, other.x);
        y_a = Math.min(this.y, other.y);
        return new Vector2d(x_a,y_a);
    }
    Vector2d add(Vector2d other){
        int x_a,y_a;
        x_a = this.x + other.x;
        y_a = this.y + other.y;
        return new Vector2d(x_a,y_a);
    }
    Vector2d subtract(Vector2d other){
        int x_a,y_a;
        x_a = this.x - other.x;
        y_a = this.y - other.y;
        return new Vector2d(x_a,y_a);
    }
    @Override
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return that.x == this.x && that.y == this.y;
    }
    Vector2d opposite(){
        return new Vector2d(-this.x,-this.y);
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}
