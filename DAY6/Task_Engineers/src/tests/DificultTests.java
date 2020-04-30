package tests;

import DAY4.entity.AutomatedMyTest;
import DAY4.entity.ManualMyTest;
import DAY4.entity.Result;
import DAY4.entity.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import DAY4.worker.AutomationEngineer;
import DAY4.worker.TestEngineer;

public class DificultTests {
    @Test
    public void manualTestPassed() {
        ManualMyTest manualTest = new ManualMyTest(TestLevel.GUI, 4);
        TestEngineer testEngineer = new TestEngineer();
        testEngineer.setSkill(4);
        Assert.assertEquals("ManualTest, AutomationEngineer, GUI(9), instability 4, anxiety 3: ", Result.PASSED, manualTest.apply(testEngineer));
    }
    @Test
    public void manualTestFailed(){
        ManualMyTest manualTest = new ManualMyTest(TestLevel.GUI, 4);
        AutomationEngineer automationEngineer = new AutomationEngineer();
        automationEngineer.setSkill(1);
        Assert.assertEquals("ManualTest, AutomationEngineer, GUI(9), instability 4, anxiety 3: ", Result.FAILED, manualTest.apply(automationEngineer));
    }

    @Test
    public void automatedTestPassed(){
        AutomatedMyTest autoTest = new AutomatedMyTest(TestLevel.API, 3);
        TestEngineer testEngineer = new TestEngineer();
        //testEngineer.getSkill(9);
        Assert.assertEquals("AutomationTest, AutomationEngineer, API(3), instability 3, anxiety 3: ", Result.PASSED, autoTest.apply(testEngineer));
    }

    @Test
    public void automatedTestFailed(){
        AutomatedMyTest autoTest = new AutomatedMyTest(TestLevel.GUI, 3);
        AutomationEngineer automationEngineer = new AutomationEngineer();
        Assert.assertEquals("AutomationTest, AutomationEngineer, Gui(9), instability 4, anxiety 1: ", Result.FAILED, autoTest.apply(automationEngineer));
    }

}
