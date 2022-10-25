package agh.ics.oop;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
    void test1() {
        Animal animal = new Animal();
        MoveDirection[] directions = OptionsParser.parse(new String[]{"r", "right", "f", "l", "ka","f", "f", "r"});
            for (MoveDirection dir : directions) {
                animal.move(dir);
                System.out.println(animal);
            }
            assertEquals(animal.toString(), "((4,1), Poludnie)");

    }

    @Test
    void test2(){
        Animal animal = new Animal();
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f", "f", "f", "f", "l"});
        for (MoveDirection dir : directions) {
            animal.move(dir);
            System.out.println(animal);
        }
        assertEquals(animal.toString(), "((2,4), Zachod)");
    }

    @Test
    void test3(){
        Animal animal = new Animal();
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f", "f", "kondys", "l", "l", "kul", "f"});
        for (MoveDirection dir : directions) {
            animal.move(dir);
            System.out.println(animal);
        }
        assertEquals(animal.toString(), "((2,3), Poludnie)");
    }


}


