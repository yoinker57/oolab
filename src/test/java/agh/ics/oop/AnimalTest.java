package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AnimalTest {
    public OptionParser optionParser = new OptionParser();


    IWorldMap maps = new RectangularMap(10, 5);
    Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
    String[] strings = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};

    String[] supposed_orientation = {"S", "N"};
    Vector2d[] supposed_position = {new Vector2d(2, 0), new Vector2d(3, 4)};

    @Test
    public void testMap() {
        MoveDirection[] directions = optionParser.parse(strings);
        IWorldMap map = maps;
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        int i = 0;
        for (Animal animal : ((RectangularMap) map).getAnimals()) {
            Assertions.assertEquals(animal.toString(), supposed_orientation[i]);
            Assertions.assertTrue(animal.isAt(supposed_position[i]));
            i++;
        }
    }
}


