public abstract class Test implements Function<Engineer, Result>{

    //private TestLevel testLevel;

    private int complexity;

    private int instability;

    public Test(TestLevel testLevel){
        this.complexity = testLevel.getCOMPLEXITY();
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

        if (((this instanceof ManualTest) && (engineer instanceof AutomationEngineer )) |
        ((this instanceof AutomatedTest) && (engineer instanceof TestEngineer ))) {
            anxiety = engineer.getAnxiety();
        }

        if (complexity * instability * anxiety > 30){
            result = Result.FAILED;
        }
        else {
            result = Result.PASSED;
        }

        return result;
    }
}
