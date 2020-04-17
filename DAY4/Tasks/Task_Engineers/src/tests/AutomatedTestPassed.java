package tests;
import entity.*;
import org.junit.Assert;
import org.junit.Test;
import worker.*;

public class AutomatedTestPassed {

    @Test
    public void automatedTestPassed() {
        AutomatedTest autoTest = new AutomatedTest(TestLevel.API, 3);
        TestEngineer testEngineer = new TestEngineer();
        Assert.assertEquals("AutomationTest, AutomationEngineer, API(3), instability 3, anxiety 3: ", Result.PASSED, autoTest.apply(testEngineer));
    }
}
