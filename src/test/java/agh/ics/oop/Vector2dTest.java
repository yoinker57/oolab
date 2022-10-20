package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.testng.Assert.*;


public class Vector2dTest{
    @Test
    public void Testequals(){
        assertEquals(new Vector2d(2, 1), new Vector2d(2, 1));
        assertEquals(new Vector2d(3, 5), new Vector2d(3, 5));
        assertNotEquals(new Vector2d(5, 4), new Vector2d(2, 1));
        assertNotEquals(new Vector2d(1, 2), new Vector2d(2, 1));
    }

    @Test
    public void TesttoString(){
        assertEquals(new Vector2d(2,1).toString(), "(2,1)");
        assertEquals(new Vector2d(5,4).toString(), "(5,4)");
        assertEquals(new Vector2d(0,0).toString(), "(0,0)");
        assertEquals(new Vector2d(134,512).toString(), "(134,512)");
    }
    @Test
    public void Testprecedes(){
        assertTrue(new Vector2d(1, 2).precedes(new Vector2d(3,4)));
        assertTrue(new Vector2d(52, 36).precedes(new Vector2d(52,36)));
        assertFalse(new Vector2d(5, 8).precedes(new Vector2d(3,4)));
        assertFalse(new Vector2d(3, 4).precedes(new Vector2d(1,2)));
    }
    @Test
    public void Testfollows(){
        assertFalse(new Vector2d(1, 2).follows(new Vector2d(3,4)));
        assertTrue(new Vector2d(52, 36).follows(new Vector2d(52,36)));
        assertTrue(new Vector2d(5, 8).follows(new Vector2d(3,4)));
        assertTrue(new Vector2d(3, 4).follows(new Vector2d(1,2)));
    }
    @Test
    public void TestupperRight(){
        assertEquals(new Vector2d(1, 2).upperRight(new Vector2d(5, 1)), new Vector2d(5,2));
        assertEquals(new Vector2d(53, 31).upperRight(new Vector2d(13, 48)), new Vector2d(53,48));
    }
    @Test
    public void TestlowerLeft(){
        assertEquals(new Vector2d(1, 2).lowerLeft(new Vector2d(5, 1)), new Vector2d(1,1));
        assertEquals(new Vector2d(53, 31).lowerLeft(new Vector2d(13, 48)), new Vector2d(13,31));
    }
    @Test
    public void TestAdd(){
        assertEquals(new Vector2d(1, 2).add(new Vector2d(5, 1)), new Vector2d(6,3));
        assertEquals(new Vector2d(53, 31).add(new Vector2d(13, 48)), new Vector2d(66,79));
    }
    @Test
    public void TestSubtract(){
        assertEquals(new Vector2d(1, 2).subtract(new Vector2d(5, 1)), new Vector2d(-4,1));
        assertEquals(new Vector2d(53, 31).subtract(new Vector2d(13, 48)), new Vector2d(40,-17));
    }
    @Test
    public void Testopposite(){
        assertEquals(new Vector2d(1, 2).opposite(), new Vector2d(-1,-2));
        assertEquals(new Vector2d(53, 31).opposite(), new Vector2d(-53,-31));

    }

}
