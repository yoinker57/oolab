package agh.ics.oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AnimalTest {
    private final IWorldMap map = new RectangularMap(4, 4);
    private final OptionParser parser = new OptionParser();
    private final Animal test_animal1 = new Animal(map,new Vector2d(2,2));
    private final Animal test_animal2 = new Animal(map,new Vector2d(2,2));
    private final Animal test_animal3 = new Animal(map,new Vector2d(2,2));
    private final Animal test_animal4 = new Animal(map,new Vector2d(2,2));
    @Test
    void move_orientation(){
        String[] array_1 = new String[]{"l","r","l","l"};
        MoveDirection[] moves_1 = parser.parse(array_1);
        for (MoveDirection move : moves_1){
            test_animal1.move(move);
        }
        Assertions.assertEquals(test_animal1.getDirection(),MapDirection.SOUTH);
        String[] array_2 = new String[]{"l","r","r","r","r"};
        MoveDirection[] moves_2 = parser.parse(array_2);
        for (MoveDirection move : moves_2){
            test_animal2.move(move);
        }
        Assertions.assertEquals(test_animal2.getDirection(),MapDirection.WEST);
    }
    @Test
    void move_position(){
        String[] array_1 = new String[]{"l","f","f","b","r","f"};
        MoveDirection[] moves_1 = parser.parse(array_1);
        for (MoveDirection move : moves_1){
            test_animal1.move(move);
        }
        Assertions.assertTrue(test_animal1.isAt(new Vector2d(1,3)));
        String[] array_2 = new String[]{"l","l","f","f","f","b","b","r","b","r","f"};
        MoveDirection[] moves_2 = parser.parse(array_2);
        for (MoveDirection move : moves_2){
            test_animal2.move(move);
        }
        Assertions.assertTrue(test_animal2.isAt(new Vector2d(3,3)));
        String[] array_3 = new String[]{"r","f","f","r","f","f"};
        MoveDirection[] moves_3 = parser.parse(array_3);
        for (MoveDirection move : moves_3){
            test_animal3.move(move);
        }
        Assertions.assertTrue(test_animal3.isAt(new Vector2d(4,0)));
    }
    @Test
    void move_out(){
        String[] array_1 = new String[]{"f","f","f","f"};
        MoveDirection[] moves_1 = parser.parse(array_1);
        for (MoveDirection move : moves_1){
            test_animal1.move(move);
        }
        Assertions.assertTrue(test_animal1.isAt(new Vector2d(2,4)));
        String[] array_2 = new String[]{"r","f","f","f","f"};
        MoveDirection[] moves_2 = parser.parse(array_2);
        for (MoveDirection move : moves_2){
            test_animal2.move(move);
        }
        Assertions.assertTrue(test_animal2.isAt(new Vector2d(4,2)));
        String[] array_3 = new String[]{"b","b","b","b"};
        MoveDirection[] moves_3 = parser.parse(array_3);
        for (MoveDirection move : moves_3){
            test_animal3.move(move);
        }
        Assertions.assertTrue(test_animal3.isAt(new Vector2d(2,0)));
        String[] array_4 = new String[]{"l","f","f","f","f"};
        MoveDirection[] moves_4 = parser.parse(array_4);
        for (MoveDirection move : moves_4){
            test_animal4.move(move);
        }
        Assertions.assertTrue(test_animal4.isAt(new Vector2d(0,2)));
    }
}