package agh.ics.oop;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    private final GrassField grassField = new GrassField(10);

    @Test
    public void testObjectAt() {
        List<Grass> grassList = grassField.getGrass();
        for (Grass g : grassList) {
            Object o = grassField.objectAt(g.getPosition());
            assertTrue(o instanceof Grass);
        }
        Vector2d apos = grassList.get(0).getPosition();
        Animal a = new Animal(grassField, apos);
        grassField.place(a);

        assertEquals(a, grassField.objectAt(apos));
    }

    @Test
    public void testIsOccupied() {
        List<Grass> grassList = grassField.getGrass();
        for (Grass g : grassList) {
            assertTrue(grassField.isOccupied(g.getPosition()));
        }

        Animal a1 = new Animal(grassField, new Vector2d(-10, 10));
        grassField.place(a1);

        assertTrue(grassField.isOccupied(a1.getPosition()));
    }

    @Test
    public void testCanMoveTo() {
        List<Grass> grassList = grassField.getGrass();
        for (Grass g : grassList) {
            assertTrue(grassField.canMoveTo(g.getPosition()));
        }

        grassField.place(new Animal(grassField, new Vector2d(-1, -1)));
        assertFalse(grassField.canMoveTo(new Vector2d(-1, -1)));
    }

    @Test
    public void testPlace() {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        Vector2d[] positions = new Vector2d[]{
                new Vector2d(max, max),
                new Vector2d(max, min),
                new Vector2d(min, max),
                new Vector2d(min, min)
        };

        Animal[] animals = new Animal[]{
                new Animal(grassField, positions[0]),
                new Animal(grassField, positions[1]),
                new Animal(grassField, positions[2]),
                new Animal(grassField, positions[3])
        };

        for (Animal a : animals) {
            grassField.place(a);
        }

        for (Vector2d pos : positions) {
            assertTrue(
                    !grassField.canMoveTo(pos)
                            && grassField.isOccupied(pos));
        }
    }


}
