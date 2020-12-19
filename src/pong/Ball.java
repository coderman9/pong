package pong;

public class Ball {
    private double xPos;
    private double yPos;
    private double xVel;
    private double yVel;

    public Ball(double xPos, double yPos, double xVel, double yVel){
        this.xPos = xPos;
        this.yPos = yPos;
        this.xVel = xVel;
        this.yVel = yVel;
    }

    public void bounceOffPaddle(){
        xVel *= -1;
    }

    public void bounceOffWall(){
        yVel *= -1;
    }

    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }

    public void update(){
        xPos += xVel;
        yPos += yVel;
    }
}