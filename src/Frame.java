import java.util.ArrayList;
import java.util.List;

public class Frame {
    private List<Integer> balls = new ArrayList<Integer>();

    public Frame(List<Integer> balls) {
        this.balls=balls;
    }

    public int getScore() {

        return balls.get(0);
    }

    public int getFirstBall() {
        return balls.get(0);
    }
}
