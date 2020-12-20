package pong;

public class AIPlayer implements Player {

    int points = 0;

    @Override
    public double getYPos() {
        return 0;
    }

    @Override
    public void addPoint() {
        points++;
    }

    @Override
    public int getPoints() {
        return points;
    }
}
