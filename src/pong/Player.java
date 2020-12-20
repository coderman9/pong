package pong;

public interface Player {
    double getYPos();
    void addPoint();
    int getPoints();
    void setBall(Ball ball);
}
