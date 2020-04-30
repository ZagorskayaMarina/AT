package tests;

import DAY4.entity.*;
import DAY4.worker.AutomationEngineer;
import DAY4.worker.Engineer;
import DAY4.worker.TestEngineer;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApplyMethodTests {
    private MyTest test;
    private Engineer engineer;
    private int skill;
    private Result result;

    public ApplyMethodTests(MyTest test, Engineer engineer, int skill, Result result){
        this.test = test;
        this.engineer = engineer;
        this.skill = skill;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        return Arrays.asList(new Object[][]{
                {new AutomatedMyTest(TestLevel.UNIT, 1), new AutomationEngineer(), 1, Result.PASSED},
                {new AutomatedMyTest(TestLevel.GUI, 10), new TestEngineer(), 10, Result.PASSED},
                {new ManualMyTest(TestLevel.API, 0), new AutomationEngineer(), 1, Result.PASSED},
                {new ManualMyTest(TestLevel.UNIT, 10), new AutomationEngineer(), 10, Result.PASSED},
                {new ManualMyTest(TestLevel.UNIT, 0), new TestEngineer(), 10, Result.PASSED},
                {new AutomatedMyTest(TestLevel.GUI, 11), new TestEngineer(), 1, Result.FAILED},
                {new AutomatedMyTest(TestLevel.GUI, 0), new AutomationEngineer(), 10, Result.PASSED},
                {new AutomatedMyTest(TestLevel.API, 10), new AutomationEngineer(), 1, Result.FAILED},
                {new AutomatedMyTest(TestLevel.API, 1), new TestEngineer(), 1, Result.PASSED},
                {new AutomatedMyTest(TestLevel.UNIT, 0), new TestEngineer(), 10, Result.PASSED},
                {new ManualMyTest(TestLevel.API, 10), new TestEngineer(), 1, Result.FAILED},
                {new ManualMyTest(TestLevel.API, 11), new TestEngineer(), 10, Result.PASSED},
                {new ManualMyTest(TestLevel.GUI, 0), new AutomationEngineer(), 1, Result.PASSED},
                {new ManualMyTest(TestLevel.GUI, 1), new TestEngineer(), 10, Result.PASSED},
                {new ManualMyTest(TestLevel.UNIT, 11), new AutomationEngineer(), 10, Result.PASSED},
                {new AutomatedMyTest(TestLevel.UNIT, 11), new AutomationEngineer(), 1, Result.PASSED}
        });
    }

    @org.junit.Test
    public void applyTest() {
        engineer.setSkill(skill);
        Assert.assertEquals("Test isn't correct", result,  test.apply(engineer));
    }

}
