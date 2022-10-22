package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AnimalTest {
    @Test
    public void TesttoString(){
        assertEquals(new Animal().toString(), "((2,2), Polnoc)");
    }

    @Test
    public void TestisPosition(){
        assertTrue(new Animal().isAt(new Vector2d(3,2)));
    }

    @Test
    public void Testmove(){
        assertEquals( , );
    }
}
