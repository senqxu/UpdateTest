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
            System.out.println("extraScore = " + extraScore);
            score += baseScore + extraScore;
            System.out.println("extraScore = " + baseScore);
        }
        return score;
    }

    private ArrayList<Frame> parse(String bowlingCode) {
        String[] framesAndExtraBalls = bowlingCode.split("\\|\\|");
        String[] framesStr = framesAndExtraBalls[0].split("\\|");
        String[] extraBallsStr = framesAndExtraBalls[1].split("");
        ArrayList<Frame> frames = new ArrayList<Frame>();

        for (int index = 0; index < Frame_COUNT; index++) {
            List<Integer> balls = new ArrayList<Integer>();
            String ballStr = framesStr[index];
            String[] ballString = ballStr.split("");
            if (framesStr[index].endsWith("/")) {
                Integer firstBall = getBottleCount(ballString[0]);
                balls.add(firstBall);
                balls.add(10 - firstBall);
            } else {
                for (String ballStrs : ballString) {
                    balls.add(getBottleCount(ballStrs));
                }
            }
            frames.add(new Frame(balls));
        }

        for (String extraBall : extraBallsStr) {
            List<Integer> extraBalls = new ArrayList<Integer>();
            extraBalls.add(getBottleCount(extraBall));
            frames.add(new Frame(extraBalls));
        }
        return frames;
    }

    private Integer getBottleCount(String framesStr) {
        if (framesStr.equalsIgnoreCase("X"))
            return 10;
        return Integer.valueOf(framesStr);
    }

    private int getExtraScore(int index) {
        List<Integer> extraBalls = getExtraBalls(frames, index);
        int extraBallCount = frames.get(index).getExtraBallCount();
        if (extraBallCount == 2) {
            return extraBalls.get(0) + extraBalls.get(1);
        }
        if (extraBallCount == 1) {
            return extraBalls.get(0);
        }
        return 0;
    }

    private List<Integer> getExtraBalls(List<Frame> frames, int index) {
        List<Integer> balls = new ArrayList<Integer>();
        balls.addAll(frames.get(index + 1).getBalls());
        if (frames.size() == 12) {

        }
        balls.addAll(frames.get(index + 2).getBalls());
        return balls;
    }
}
