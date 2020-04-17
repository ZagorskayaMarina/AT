package tests;

import entity.AutomatedTest;
import entity.ManualTest;
import entity.Result;
import entity.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import worker.TestEngineer;

public class ManualTestPassed {
    @Test
    public void automatedTestPassed() {
        ManualTest manualTest = new ManualTest(TestLevel.GUI, 4);
        TestEngineer testEngineer = new TestEngineer();
        Assert.assertEquals("ManualTest, AutomationEngineer, GUI(9), instability 4, anxiety 3: ", Result.PASSED, manualTest.apply(testEngineer));
    }
}
