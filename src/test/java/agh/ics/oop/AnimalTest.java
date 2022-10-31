package agh.ics.oop;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    IWorldMap[] MAPS = {new RectangularMap(10, 5), new RectangularMap(8, 6)};

    Vector2d[][] POSITIONS = {{new Vector2d(2, 2), new Vector2d(3, 4)},
            {new Vector2d(1, 2), new Vector2d(0, 0), new Vector2d(3, 3), new Vector2d(0, 0)}
    };
    String[][] DIRECTIONS = { {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f" },
            {"r", "f", "b", "f", "f", "l", "l", "f", "f", "f", "f", "f", "r", "f", "l", "f", "f", "f", "f", "f", "f", "l", "f", "f", "f"}
    };

    String[][] ORIENTATIONS = {{"S", "N"},
            {"N", "N", "S" }
    };

    Vector2d[][] FINISH_POSITIONS = {{new Vector2d(2, 0), new Vector2d(3, 4)},
            {new Vector2d(4, 4), new Vector2d(0, 5), new Vector2d(2, 0)}

    };

    @Test
    public void testMap1() {
        MoveDirection[] directions = OptionsParser.parse(DIRECTIONS[0]);
        IWorldMap map = MAPS[0];
        IEngine engine = new SimulationEngine(directions, map, POSITIONS[0]);
        engine.run();
        int i = 0;
        for (Animal animal : ((RectangularMap) map).getAnimals()) {
            assertEquals(animal.toString(), ORIENTATIONS[0][i]);
            assertTrue(animal.isAt(FINISH_POSITIONS[0][i]));
            i++;
        }
    }

    @Test
    public void testMap2() {
        MoveDirection[] directions = OptionsParser.parse(DIRECTIONS[1]);
        IWorldMap map = MAPS[1];
        IEngine engine = new SimulationEngine(directions, map, POSITIONS[1]);
        engine.run();
        int i = 0;
        for (Animal animal : ((RectangularMap) map).getAnimals()) {
            assertEquals(animal.toString(), ORIENTATIONS[1][i]);
            assertTrue(animal.isAt(FINISH_POSITIONS[1][i]));
            i++;
        }
    }


}


