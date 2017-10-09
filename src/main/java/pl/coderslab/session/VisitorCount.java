package pl.coderslab.session;

import java.io.Serializable;

public class VisitorCount implements Serializable {
    private static final long serialVersionUID = 3937135319319165319L;

    private int count ;

    public VisitorCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "VisitorCount{" +
                "count=" + count +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
