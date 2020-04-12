import org.testng.annotations.*;

import static org.testng.AssertJUnit.*;

public class TestNgTest {
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
