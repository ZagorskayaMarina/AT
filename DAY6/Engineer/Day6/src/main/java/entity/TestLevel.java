package entity;

public enum  TestLevel {
    UNIT(1), API(3), GUI(9);
    private int COMPLEXITY;

    TestLevel(int complexity) {
        this.COMPLEXITY = complexity;
    }

    public int getCOMPLEXITY(){
        return COMPLEXITY;
    }

    public void setCOMPLEXITY(int COMPLEXITY) {
        this.COMPLEXITY = COMPLEXITY;
    }
}
