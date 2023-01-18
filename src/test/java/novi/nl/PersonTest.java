package novi.nl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void getNameReturnsName(){
        Person hansje = new Person("Hansje", "Targaryen", 18, "non-binair");
        //act
        String naamhasje = hansje.getName();

        assertEquals("Hansje",naamhasje);

    }

    @Test
    public void addChildAddsChildToChildrensList(){
        //assert
        Person hansje = new Person("Hansje", "Targaryen", 38, "non-binair");
        Person klaasje = new Person("Klaasje", "Targaryen", 18, "unicorn");

        //act
        hansje.addChild(klaasje);
        List<Person> hansjesChildren = hansje.getChildren();

        assertEquals(hansjesChildren, hansje.getChildren());



    }
}
