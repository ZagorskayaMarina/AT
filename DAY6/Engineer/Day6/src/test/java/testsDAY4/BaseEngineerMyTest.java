package testsDAY4;

import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BaseEngineerMyTest {

    private Engineer en;

    public BaseEngineerMyTest(Engineer en) {
        this.en = en;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumber() {
        return Arrays.asList(new Object[][]{
                {new TestEngineer()},
                {new AutomationEngineer()}
        });
    }

    @Test
    public void verifyDefaultAnxietyByManualTest() {
        Assert.assertEquals("Default Anxiety is not correct", 3, en.getAnxiety());
    }

    @Test
    public void verifySetAnxietyByManualTest() {
        Assert.assertEquals("Set Anxiety is not correct", 11, en.getAnxiety());
    }
}