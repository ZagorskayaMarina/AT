package tests;

import entity.AutomatedTest;
import entity.Result;
import entity.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

public class InstabilityTests {

    private Engineer testEngineer = new TestEngineer();
    private Engineer automationEngineer = new AutomationEngineer();

    @Test
    public void instabilityLessNull() {
        AutomatedTest autoTest = new AutomatedTest(TestLevel.API, 0);
        Assert.assertEquals("If instability %d less than null instability = %d", 0, autoTest.getInstability());
    }
    @Test
    public void instabilityMore10() {
        AutomatedTest autoTest = new AutomatedTest(TestLevel.API, 11);
        Assert.assertEquals("If instability %d more than 10 instability = %d", 10, autoTest.getInstability());
    }
    @Test
    public void instabilityBetween1and10() {
        AutomatedTest autoTest = new AutomatedTest(TestLevel.API, 9);
        Assert.assertEquals("If instability %d value in a range between 1 and 10 instability = %d", 9, autoTest.getInstability());
    }
}
