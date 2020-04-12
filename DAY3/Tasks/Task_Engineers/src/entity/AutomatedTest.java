package entity;

public class AutomatedTest extends Test {
    private int instability;
    public AutomatedTest(TestLevel level, int instability) {
        super(level);
        this.instability = instability;
    }

}
