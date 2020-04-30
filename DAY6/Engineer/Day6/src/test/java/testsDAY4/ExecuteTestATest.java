package testsDAY4;

import entity.ManualMyTest;
import entity.MyTest;
import entity.Result;
import entity.TestLevel;
import worker.Engineer;
import worker.TestEngineer;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ExecuteTestATest {
    private Engineer en;
    private MyTest myTest;
    private  int skill;
    private Result expected;

    public ExecuteTestATest(Engineer en, int skill, MyTest myTest, Result expected) {
        this.en = en;
        this.skill = skill;
        this.myTest = myTest;
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
        Assert.assertEquals("Engineer Anxity is not correct", expected, en.executeTest(myTest));
    }

}
