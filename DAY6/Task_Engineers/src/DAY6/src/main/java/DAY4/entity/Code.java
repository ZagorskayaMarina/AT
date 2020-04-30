package DAY4.entity;

public class Code {

    private int lines;

    public Code() {
    }

    public Code (int lines) {
        this.lines = lines;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public void develop(int hours){
        this.lines +=25 * hours;
    }
}
