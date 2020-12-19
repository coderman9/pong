package pong;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.util.Random;

public class Pong {

    private Player player1;
    private Player player2;
    private Ball ball;
    private Random r;

    @FXML
    private Rectangle leftPaddle;
    @FXML
    private Circle circle;
    @FXML
    private Rectangle rightPaddle;

    private final double HEIGHT = 590;
    private final double WIDTH = 1211;

    public Pong(){
        player1 = new HumanPlayer();
        player2 = new AIPlayer();
        r = new Random();
    }

    public void initialize(){
        //TODO: make layouts depend upon field dimensions
        //TODO: abstract paddles
        leftPaddle.setLayoutX(10);
        rightPaddle.setLayoutX(1200);
        leftPaddle.setLayoutY(HEIGHT/2.0 - (50.0/2));
        rightPaddle.setLayoutY(HEIGHT/2.0 - (50.0/2));
        leftPaddle.setHeight(50);
        rightPaddle.setHeight(50);
        leftPaddle.setWidth(5);
        rightPaddle.setWidth(5);
        circle.setRadius(10);
    }

    public void startRound(){
        double xVel = r.nextDouble() - 0.5;
        double yVel = r.nextDouble() - 0.5;
        double mag = Math.pow(Math.pow(xVel, 2) + Math.pow(yVel, 2), 1.0/2.0);
        //xVel /= mag;
        //yVel /= mag;
        xVel = -0.5682359483870596;
        yVel = 0.8228656676278692;

        ball = new Ball(WIDTH/2.0, HEIGHT/2.0, xVel*2, yVel*2);
        System.out.println(ball.getXPos() + " " + ball.getYPos());
        System.out.println(xVel + " " + yVel);
        circle.relocate(ball.getXPos(), ball.getYPos());
        AnimationTimer at = new AnimationTimer() {
            private long startTime = -1;
            private long nextTime = 0;
            @Override
            public void handle(long now) {
                if(startTime < 0) startTime = now;
                if(now > nextTime){
                    ball.update();
                    if(ball.getYPos() <= 0 || ball.getYPos() >= HEIGHT) ball.bounceOffWall();
                    if (ball.getXPos() <= 15) {
                        if(ball.getYPos() >= leftPaddle.getLayoutY() &&
                                ball.getYPos() <= leftPaddle.getLayoutY() + leftPaddle.getHeight())
                            ball.bounceOffPaddle();
                    }
                    if (ball.getXPos() >= WIDTH - 15) {
                        if(ball.getYPos() >= rightPaddle.getLayoutY() &&
                                ball.getYPos() <= rightPaddle.getLayoutY() + rightPaddle.getHeight())
                            ball.bounceOffPaddle();
                    }
                    leftPaddle.setLayoutY(player1.getYPos());
                    rightPaddle.setLayoutY(player2.getYPos());
                    circle.relocate(ball.getXPos(), ball.getYPos());
                    nextTime = now + 10;
                }
            }
        };

        at.start();
    }
}
