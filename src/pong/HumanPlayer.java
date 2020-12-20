package pong;

public class HumanPlayer implements Player {

    int points = 0;

    Ball ball;

    public void setBall(Ball ball) {
        this.ball = ball;
    }

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
