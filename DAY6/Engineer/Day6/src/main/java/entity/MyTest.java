package entity;

import worker.AutomationEngineer;
import worker.Engineer;
import worker.TestEngineer;

import java.util.function.Function;

public abstract class MyTest implements Function<Engineer, Result> {

    //private DAY4.entity.TestLevel testLevel;

    private int complexity;

    private int instability;

//    public MyTest(TestLevel testLevel){
//        this.complexity = testLevel.getCOMPLEXITY();
//    }

    public MyTest(TestLevel testLevel, int instability){
        this.complexity = testLevel.getCOMPLEXITY();
        if (instability <= 0){
            this.instability = 0;
        } else if (instability > 10){
            this.instability = 10;
        } else {
            this.instability = instability;
        }
    }

    public void setInstability(int instability) {
        this.instability = instability;
    }

    public int getInstability() {
        return instability;
    }

    @Override
    public Result apply(Engineer engineer) {

        int anxiety = engineer.getAnxiety();

        Result result;

        if (((this instanceof ManualMyTest) && (engineer instanceof AutomationEngineer)) ||
        ((this instanceof AutomatedMyTest) && (engineer instanceof TestEngineer))) {
            engineer.setAnxiety(anxiety);
        } else {
            engineer.setAnxiety(1);
        }

        if ((complexity * instability * anxiety)/engineer.getSkill() > 30){
            result = Result.FAILED;
        }
        else {
            result = Result.PASSED;
        }

        return result;
    }
}
