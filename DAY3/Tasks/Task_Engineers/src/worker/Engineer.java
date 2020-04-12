package worker;

import entity.*;
import entity.Test;
import org.hamcrest.*;
import org.junit.*;
import people.Person;


public abstract class Engineer extends Person {
    private int skill = (int) (Math.random() * 10) +1;
    private int anxiety = 3;

    public int getAnxiety() {
        return anxiety;
    }

    public int getSkill() {
        return skill;
    }

    public Result executeTest(Test test) {
        return test.apply(this);
    }

    public Code invent(int hours){
        Code code = new Code();
        code.develop(hours);
        return code;
    }

}
