package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class OptionParserTest {

    @Test
    void correctParser(){
        String[] strAr1=new String[] {"r", "right", "f","forward","r","right","l","left"};
        OptionParser optionParser=new OptionParser();
        MoveDirection[] moveDirections1=optionParser.parse(strAr1);
        MoveDirection[] moveDirections2=new MoveDirection[] {MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.LEFT,MoveDirection.LEFT};
        Assertions.assertArrayEquals(moveDirections2,moveDirections1);

        String[] strAr2=new String[] {"r", "right", "f","forward","r","right","l","left","darek"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> optionParser.parse(strAr2));

        String[] strAr3=new String[] {"aaaaaaaaa"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> optionParser.parse(strAr3));
    }
}
