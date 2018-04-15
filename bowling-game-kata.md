# Bowling Game Kata

http://kata-log.rocks/bowling-game-kata

## Bowling Rules

The game consists of 10 frames. In each frame the player has two rolls to knock down 10 pins. The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.

A spare is when the player knocks down all 10 pins in two rolls. The bonus for that frame is the number of pins knocked down by the next roll.

A strike is when the player knocks down all 10 pins on his first roll. The frame is then completed with a single roll. The bonus for that frame is the value of the next two rolls.

In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. However no more than three balls can be rolled in tenth frame.

## Requirements
 
Write a class Game that has two methods

1. void roll(int) is called each time the player rolls a ball. The argument is the number of pins knocked down.
2. int score() returns the total score for that game.

## Notes and TODO

https://sites.google.com/site/unclebobconsultingllc/home/articles/the-bowling-game-an-example-of-test-first-pair-programming

* the tests show whether you need a new class or not. Don't build them until the code forces you to

Rewrite it with following differences

* start with a UML diagram that shows what are the entities you suppose should be in the system: frame, throws. The try to write some test using them, but always ask yourself the question WHAT IS THE BEHAVIOR OF THIS OBJECT? If an object doesn't have a behavior, but just data, than is useless.

* you could use a LinkedList to connect the frames.