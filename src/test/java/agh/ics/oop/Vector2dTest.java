package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.testng.Assert.*;


public class Vector2dTest{
    @Test
    public void Testequals(){
        assertEquals(new World.Vector2d(2, 1), new World.Vector2d(2, 1));
        assertEquals(new World.Vector2d(3, 5), new World.Vector2d(3, 5));
        assertNotEquals(new World.Vector2d(5, 4), new World.Vector2d(2, 1));
        assertNotEquals(new World.Vector2d(1, 2), new World.Vector2d(2, 1));
    }

    @Test
    public void TesttoString(){
        assertEquals(new World.Vector2d(2,1).toString(), "(2,1)");
        assertEquals(new World.Vector2d(5,4).toString(), "(5,4)");
        assertEquals(new World.Vector2d(0,0).toString(), "(0,0)");
        assertEquals(new World.Vector2d(134,512).toString(), "(134,512)");
    }
    @Test
    public void Testprecedes(){
        assertTrue(new World.Vector2d(1, 2).precedes(new World.Vector2d(3,4)));
        assertTrue(new World.Vector2d(52, 36).precedes(new World.Vector2d(52,36)));
        assertFalse(new World.Vector2d(5, 8).precedes(new World.Vector2d(3,4)));
        assertFalse(new World.Vector2d(3, 4).precedes(new World.Vector2d(1,2)));
    }
    @Test
    public void Testfollows(){
        assertFalse(new World.Vector2d(1, 2).follows(new World.Vector2d(3,4)));
        assertTrue(new World.Vector2d(52, 36).follows(new World.Vector2d(52,36)));
        assertTrue(new World.Vector2d(5, 8).follows(new World.Vector2d(3,4)));
        assertTrue(new World.Vector2d(3, 4).follows(new World.Vector2d(1,2)));
    }
    @Test
    public void TestupperRight(){
        assertEquals(new World.Vector2d(1, 2).upperRight(new World.Vector2d(5, 1)).toString(), "(5,2)");
        assertEquals(new World.Vector2d(53, 31).upperRight(new World.Vector2d(13, 48)).toString(), "(53,48)");
        assertNotEquals(new World.Vector2d(1, 2).upperRight(new World.Vector2d(5, 1)).toString(), "(2,1)");
        assertNotEquals(new World.Vector2d(1, 2).upperRight(new World.Vector2d(5, 1)).toString(), "(1,1)");
    }
    @Test
    public void TestlowerLeft(){
        assertEquals(new World.Vector2d(1, 2).lowerLeft(new World.Vector2d(5, 1)).toString(), "(1,1)");
        assertEquals(new World.Vector2d(53, 31).lowerLeft(new World.Vector2d(13, 48)).toString(), "(13,31)");
        assertNotEquals(new World.Vector2d(1, 2).lowerLeft(new World.Vector2d(5, 1)).toString(), "(5,2)");
        assertNotEquals(new World.Vector2d(1, 2).lowerLeft(new World.Vector2d(5, 1)).toString(), "(5,1)");
    }
    @Test
    public void TestAdd(){
        assertEquals(new World.Vector2d(1, 2).add(new World.Vector2d(5, 1)).toString(), "(6,3)");
        assertEquals(new World.Vector2d(53, 31).add(new World.Vector2d(13, 48)).toString(), "(66,79)");
        assertNotEquals(new World.Vector2d(1, 2).add(new World.Vector2d(5, 1)).toString(), "(5,2)");
        assertNotEquals(new World.Vector2d(1, 2).add(new World.Vector2d(5, 1)).toString(), "(5,1)");
    }
    @Test
    public void TestSubtract(){
        assertEquals(new World.Vector2d(1, 2).subtract(new World.Vector2d(5, 1)).toString(), "(-4,1)");
        assertEquals(new World.Vector2d(53, 31).subtract(new World.Vector2d(13, 48)).toString(), "(40,-17)");
        assertNotEquals(new World.Vector2d(1, 2).subtract(new World.Vector2d(5, 1)).toString(), "(5,2)");
        assertNotEquals(new World.Vector2d(1, 2).subtract(new World.Vector2d(5, 1)).toString(), "(4,1)");
    }
    @Test
    public void Testopposite(){
        assertEquals(new World.Vector2d(1, 2).opposite().toString(), "(-1,-2)");
        assertEquals(new World.Vector2d(53, 31).opposite().toString(), "(-53,-31)");
        assertNotEquals(new World.Vector2d(1, 2).opposite().toString(), "(1,2)");
        assertNotEquals(new World.Vector2d(1, 2).opposite().toString(), "(4,1)");
    }

}
