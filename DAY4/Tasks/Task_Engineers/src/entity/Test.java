package entity;

import worker.*;

import java.util.function.Function;

public abstract class Test implements Function<Engineer, Result> {

    //private entity.TestLevel testLevel;

    private int complexity;

    private int instability;

    public Test(TestLevel testLevel){
        this.complexity = testLevel.getCOMPLEXITY();
    }

    public Test(TestLevel testLevel, int instability){
        this.complexity = testLevel.getCOMPLEXITY();
        if (instability <= 0){
            instability = 0;
        } else if (instability > 10){
            instability = 10;
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

        int anxiety = 1;

        Result result;

        if (((this instanceof ManualTest) && (engineer instanceof AutomationEngineer)) |
        ((this instanceof AutomatedTest) && (engineer instanceof TestEngineer))) {
            anxiety = engineer.getAnxiety();
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
