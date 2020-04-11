public class Runner {
    public static void main(String[] args){
        Person marina = new Person("Marina", "Zagorskaya");
        marina.setAge(18);

        marina.speak();

        Engineer testEngineer = new TestEngineer();
        System.out.println(String.format("Person name is %s %s, person age is %d, person has %s profession," +
                "person professional skills are %d, person has %d anxiety level",
                marina.getName(), marina.getSurname(), marina.getAge(), testEngineer.getClass().getSimpleName(),
                testEngineer.getSkill(), testEngineer.getAnxiety()));
        //testEngineer.executeTest();
    }

}
