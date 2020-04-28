import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void personAgeTest() {
        Person person = new Person(25);
        assertEquals("Person age is not as expected!", person.getAge(), 25);
    }

    @Test
    public void personAgeFailTest(){
        Person person = new Person(26);
        assertEquals("Person age is not as expected!", 25, person.getAge());
    }
}
