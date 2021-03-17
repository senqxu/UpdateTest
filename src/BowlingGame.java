import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    public static final int Frame_COUNT = 10;
    private List<Frame> frames;

    public int getBowlingScoere(String bowlingCode) {
        frames = parse(bowlingCode);
        int score = calculate();
        return score;
    }

    private int calculate() {

        int score = 0;
        for (int index = 0; index < Frame_COUNT; index++) {
            Frame frame = frames.get(index);
            int baseScore = frame.getScore();
            int extraScore = getExtraScore(index);
            score += baseScore + extraScore;

        }
        return score;
    }

    private ArrayList<Frame> parse(String bowlingCode) {
        String[] framesAndExtraBalls = bowlingCode.split("\\|\\|");
        String[] framesStr = framesAndExtraBalls[0].split("\\|");
        ArrayList<Frame> frames = new ArrayList<Frame>();

        for (int index = 0; index < Frame_COUNT; index++) {
            List<Integer> balls = new ArrayList<Integer>();
            balls.add(getBottleCount(framesStr[index]));
            frames.add(new Frame(balls));
        }

        List<Integer> extraBalls = new ArrayList<Integer>();
        extraBalls.add(10);
        extraBalls.add(10);
        frames.add(new Frame(extraBalls));
        return frames;
    }

    private Integer getBottleCount(String framesStr) {
        if (framesStr.equalsIgnoreCase("X"))
            return 10;
        return null;
    }

    private int getExtraScore(int index) {
        Frame nextFrame = frames.get(index);
        int nextBall = nextFrame.getFirstBall();
        int nextNextBall = 10;
        return nextBall + nextNextBall;
    }
}
