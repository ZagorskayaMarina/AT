package tests;

import DAY4.entity.*;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import DAY4.worker.Engineer;
import DAY4.worker.TestEngineer;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ExecuteTestATest {
    private Engineer en;
    private MyTest test;
    private  int skill;
    private Result expected;

    public ExecuteTestATest(Engineer en, int skill, MyTest test, Result expected) {
        this.en = en;
        this.skill = skill;
        this.test = test;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        return Arrays.asList(new Object[][]{
                {new TestEngineer(), 1, new ManualMyTest(TestLevel.UNIT, 5), Result.PASSED},
                {new TestEngineer(), 10, new ManualMyTest(TestLevel.UNIT, 5), Result.PASSED},
                {new TestEngineer(), 1, new ManualMyTest(TestLevel.API, 9), Result.PASSED},
                {new TestEngineer(), 10, new ManualMyTest(TestLevel.UNIT, 9), Result.PASSED}
        });
    }

    @org.junit.Test
    public void verifyExecuteTest() {
        en.setSkill(skill);
        Assert.assertEquals("Engineer Anxity is not correct", expected, en.executeTest(test));
    }

}
