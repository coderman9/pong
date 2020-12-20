This is a very simple Pong project.

Goals
---
1. Make something on a whim, just because I had the idea to.
2. Sharpen my abilities to write code.
3. Dip a toe in the water of game dev.

Design
---
The main driver of the game is an  ```AnimationTimer``` which does a couple of things every tick
1. Updates the position of the ball, depending on its current velocity.
    1. If the ball is touching the top/bottom or a paddle it reverses the relevant (x/y) component of velocity.
2. Updates the position of the human players paddle, depending on mouse position.
3. Updates the position of the AI players paddle, depending on whatever logic it uses
    1. Note that the AI paddle only moves 70% of the speed of the ball, in current iteration.
