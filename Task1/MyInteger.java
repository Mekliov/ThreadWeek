package Task1;

public class MyInteger {
    public int count;

    public MyInteger(int t) {
        this.count = t;
    }

    public int increment() {
        this.count = this.count + 1;
        return count;

    }

    public int decrement() {
        return count - 1;
    }

    public int getInteger() {

        return count;
    }
}
