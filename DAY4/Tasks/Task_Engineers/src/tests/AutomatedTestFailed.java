package tests;

import entity.AutomatedTest;
import entity.Result;
import entity.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import worker.AutomationEngineer;

public class AutomatedTestFailed {

    @Test
    public void automatedTestFailed(){
        AutomatedTest autoTest = new AutomatedTest(TestLevel.GUI, 3);
        AutomationEngineer automationEngineer = new AutomationEngineer();
        Assert.assertEquals("AutomationTest, AutomationEngineer, Gui(9), instability 4, anxiety 1: ", Result.FAILED, autoTest.apply(automationEngineer));
    }
}
