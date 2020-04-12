package tests;

import entity.ManualTest;
import entity.Result;
import entity.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import worker.AutomationEngineer;

public class ManualTestFailed {

    @Test
    public void manualTestFailed(){
        ManualTest manualTest = new ManualTest(TestLevel.GUI, 4);
        AutomationEngineer automationEngineer = new AutomationEngineer();
        Assert.assertEquals("ManualTest, AutomationEngineer, GUI(9), instability 4, anxiety 3: ", Result.FAILED, manualTest.apply(automationEngineer));
    }
}
