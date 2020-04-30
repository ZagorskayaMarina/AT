package tests;

import DAY4.entity.AutomatedMyTest;
import DAY4.entity.ManualMyTest;
import DAY4.entity.MyTest;
import DAY4.entity.TestLevel;
import DAY4.worker.AutomationEngineer;
import DAY4.worker.Engineer;
import DAY4.worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SkillAnxietyTests {
    private Engineer engineer;
    private MyTest test;
    private int expected;

    public SkillAnxietyTests(Engineer engineer, MyTest test, int expected){
        this.engineer = engineer;
        this.test = test;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        return Arrays.asList(new Object[][]{
                {new TestEngineer(), new ManualMyTest(TestLevel.API, 1), 1},
                {new TestEngineer(), new AutomatedMyTest(TestLevel.GUI, 10), 3},
                {new AutomationEngineer(), new AutomatedMyTest(TestLevel.API, 5), 1},
                {new AutomationEngineer(), new ManualMyTest(TestLevel.UNIT, 9), 3}
        });
    }

    @Test
    public void verifyAnxiety() {
        engineer.randomSkill();
        test.apply(engineer);
        Assert.assertEquals("Anxiety isn't correct", expected, engineer.getAnxiety());
    }

    @Test
    public void verifySkills() {
        engineer.randomSkill();
        Assert.assertTrue(engineer.getSkill() >= 1 && engineer.getSkill() <= 10);
    }

}
