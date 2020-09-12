# mars-rover
Mars Rover
A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, 
must be navigated by the rovers so that their on board cameras can get a complete view of the surrounding terrain to send back to Earth. 
A rover's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. 
The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner ,
and facing North. In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes 
the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading. 
Assume that the square directly North from (x, y) is (x, y+1). Input: The first line of input is the upper-right coordinates of the plateau, the lower-left 
coordinates are assumed to be 0,0. The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. 
The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau. 

The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation. 
Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving. 
Output: The output for each rover should be its final co-ordinates and heading. 

Test Input: 
5 5 
1 2 N 
LMLMLMLMM 
3 3 E 
MMRMMRMRRM 

Expected Output: 
1 3 N 
5 1 E

-------------------------------------------------------------------------------------------------
Details of Code Design

-> Direction Interface (North, South, West, East) : this interface was created to decide at run time Rover's direction.
-> Coordinate class was crated to keep coordinates of Rover
-> Rover class was created to keep data of a Rover (coordinate(X,Y), Direction d)
-> Platea class was created to keep data of Plateau (Coordinate(X,Y));
-> OrderCoordinator class was used to keep together a Rover and its Orders. such as: (Rover(1,2,N), Orders("LMLMLMLMM")); So OrderCoordinator coordinates 
move of a Rover on Plateau checking for its orders.
-> DataChecker was used to check data in the file and if it is not valid, it throws DataFormatException.
-> MarsRoverUtil was used to maintain main functions which are related with Rover. Such as reading file and creating Rover, Plateau.

To Test the code:

- download project
- import to your IDE
- click run for MarsRoverApplication or from Maven tab you can click "test" to run tests of junit.

