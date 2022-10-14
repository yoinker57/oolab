package agh.ics.oop;

import agh.ics.oop.World;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.*;

public class MapDirectionTest {
    @Test
    public void Testnext() {
        assertEquals(World.MapDirection.EAST.next(), World.MapDirection.SOUTH);
        assertEquals(World.MapDirection.NORTH.next(), World.MapDirection.EAST);
        assertEquals(World.MapDirection.SOUTH.next(), World.MapDirection.WEST);
        assertEquals(World.MapDirection.WEST.next(), World.MapDirection.NORTH);
    }
    @Test
    public void Testprev() {
        assertEquals(World.MapDirection.EAST.previous(), World.MapDirection.NORTH);
        assertEquals(World.MapDirection.NORTH.previous(), World.MapDirection.WEST);
        assertEquals(World.MapDirection.SOUTH.previous(), World.MapDirection.EAST);
        assertEquals(World.MapDirection.WEST.previous(), World.MapDirection.SOUTH);
    }
}

public class Vector2dTest{
    @Test
    public void Testequals(){
        assertTrue();
        assertTrue();
        assertFalse();
        assertFalse();
    }
}
