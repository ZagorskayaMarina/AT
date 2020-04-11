public class Person extends Human {
    private String name;
    private String surname;

    public Person() {};

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    };

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    @Override
    public void speak() {
        System.out.println(String.format("Hello, it is %s speaking!", this.getClass().getSimpleName()));
    }
}
