package DAY4;

import DAY4.people.Person;
import DAY4.worker.*;

public class Runner {
    public static void main(String[] args){
        Person marina = new Person("Marina", "Zagorskaya");
        marina.setAge(18);

        marina.speak();

        Engineer testEngineer = new TestEngineer();
        System.out.println(String.format("DAY4.people.Person name is %s %s, person age is %d, person has %s profession," +
                "person professional skills are %d, person has %d anxiety level",
                marina.getName(), marina.getSurname(), marina.getAge(), testEngineer.getClass().getSimpleName(),
                testEngineer.getSkill(), testEngineer.getAnxiety()));
        //testEngineer.executeTest();
    }

}
