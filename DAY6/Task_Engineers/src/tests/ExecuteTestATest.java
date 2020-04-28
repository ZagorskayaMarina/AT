package tests;

import entity.*;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import worker.Engineer;
import worker.TestEngineer;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ExecuteTestATest {
    private Engineer en;
    private Test test;
    private  int skill;
    private Result expected;

    public ExecuteTestATest(Engineer en, int skill, Test test, Result expected) {
        this.en = en;
        this.skill = skill;
        this.test = test;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        return Arrays.asList(new Object[][]{
                {new TestEngineer(), 1, new ManualTest(TestLevel.UNIT, 5), Result.PASSED},
                {new TestEngineer(), 10, new ManualTest(TestLevel.UNIT, 5), Result.PASSED},
                {new TestEngineer(), 1, new ManualTest(TestLevel.API, 9), Result.PASSED},
                {new TestEngineer(), 10, new ManualTest(TestLevel.UNIT, 9), Result.PASSED}
        });
    }

    @org.junit.Test
    public void verifyExecuteTest() {
        en.setSkill(skill);
        Assert.assertEquals("Engineer Anxity is not correct", expected, en.executeTest(test));
    }

}
