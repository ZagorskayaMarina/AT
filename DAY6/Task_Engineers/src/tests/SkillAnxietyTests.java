package tests;

import entity.*;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SkillAnxietyTests {
    private Engineer engineer;
    private Test test;
    private int expected;

    public SkillAnxietyTests(Engineer engineer, Test test, int expected){
        this.engineer = engineer;
        this.test = test;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        return Arrays.asList(new Object[][]{
                {new TestEngineer(), new ManualTest(TestLevel.API, 1), 1},
                {new TestEngineer(), new AutomatedTest(TestLevel.GUI, 10), 3},
                {new AutomationEngineer(), new AutomatedTest(TestLevel.API, 5), 1},
                {new AutomationEngineer(), new ManualTest(TestLevel.UNIT, 9), 3}
        });
    }

    @Test
    public void verifyAnxiety() {
        Assert.assertEquals("Anxiety isn't correct", expected, engineer.getAnxiety());
    }

    @Test
    public void verifySkills() {
        Assert.assertTrue(engineer.getSkill() >= 1 && engineer.getSkill() <= 10);
    }

}
