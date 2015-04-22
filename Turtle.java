package mediacomputation;
import java.util.*;
import java.awt.*;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Turtle extends SimpleTurtle
{
	////////////////// constructors ///////////////////////

	/** Constructor that takes the x and y and a picture to
	 * draw on
	 * @param x the starting x position
	 * @param y the starting y position
	 * @param picture the picture to draw on
	 */
	public Turtle (int x, int y, Picture picture) 
	{
		// let the parent constructor handle it
		super(x,y,picture);
	}

	/** Constructor that takes the x and y and a model
	 * display to draw it on
	 * @param x the starting x position
	 * @param y the starting y position
	 * @param modelDisplayer the thing that displays the model
	 */
	public Turtle (int x, int y, 
			ModelDisplay modelDisplayer) 
	{
		// let the parent constructor handle it
		super(x,y,modelDisplayer);
	}

	/** Constructor that takes the model display
	 * @param modelDisplay the thing that displays the model
	 */
	public Turtle (ModelDisplay modelDisplay) 
	{
		// let the parent constructor handle it
		super(modelDisplay);
	}

	/**
	 * Constructor that takes a picture to draw on
	 * @param p the picture to draw on
	 */
	public Turtle (Picture p)
	{
		// let the parent constructor handle it
		super(p);
	}  

	/////////////////// methods ///////////////////////

	// power-up methods

	/**
	 * Draws a square starting at the current position and heading by making left turns
	 * and returning to the starting position and heading.
	 * For example, when the Turtle has a north heading, then, this method will draw a square
	 * where the current position will be the bottom-right corner of the square.
	 * The dimensions of the square are determined by the parameter-less forward method.
	 * The Turtle is returned to the same position and heading.
	 */
	public void drawSquare() {
		forward();
		turnLeft();
		forward();
		turnLeft();
		forward();
		turnLeft();
		forward();
		turnLeft();
	}


	/**
	 * Draws a square starting at the current position and heading by making left turns
	 * and returning to the starting position and heading.
	 * For example, when the Turtle has a north heading, then, this method will draw a square
	 * where the current position will be the bottom-right corner of the square.
	 * The dimensions of the square are determined by the parameter-less forward method.
	 * The Turtle is returned to the same position and heading.
	 * 
	 * @param length is the length of the sides of the square.
	 */
	public void drawSquare(int length) {
		forward(length);
		turnLeft();
		forward(length);
		turnLeft();
		forward(length);
		turnLeft();
		forward(length);
		turnLeft();
	}

	/**
	 * Draws rectangle of width by height.... etc...
	 * 
	 * @param width the length of one of the sides of the rectangle
	 * @param height the length of the other side of the rectangle
	 */
	public void drawRectangle(int width, int height) {
		forward(height);
		turn(90);
		forward(width);
		turn(90);
		forward(height);
		turn(90);
		forward(width);
		turn(90);
	}

	public void createBorder1(int squareLength, int rectangleWidth, int rectangleHeight, int lineDistance, int penWidth, Color penColor) {
		Picture pic = this.getPicture();
		this.setPenWidth(penWidth);
		this.setPenColor(penColor);
		this.penUp();
		this.moveTo(pic.getWidth(), pic.getHeight());
		this.penDown();
		for(int i = 0; i < 4; i++) {
			this.drawSquare(squareLength);
			this.penUp();
			if(i % 2 == 0) {
				this.forward(pic.getHeight());
			} else {
				this.forward(pic.getWidth());
			}
			this.penDown();
			this.turnLeft();
		}
		this.penUp();
		this.moveTo((pic.getWidth() - 1 - rectangleWidth)/2, (pic.getHeight() - 1 - rectangleHeight) / 2);
		this.penDown();
		for(int i = 0; i < 4; i++) {
			this.turnRight();
			if(i % 2 == 0) {
				this.forward(rectangleWidth);
			} else {
				this.forward(rectangleHeight);
			}

		}
		this.penUp();
		this.moveTo(lineDistance, lineDistance);
		for(int i = 0; i < 4; i++) {
			this.turnRight();
			this.forward(squareLength - lineDistance + 10);
			this.penDown();
			if(i % 2 == 0) {
				this.forward(pic.getWidth() - 2*squareLength - 20);
			} else {
				this.forward(pic.getHeight() - 2*squareLength - 20);
			}
			this.penUp();
			this.forward(squareLength - lineDistance + 10);
		}
	}


	// QUESTION: How does a method know which object it is accessing/changing?
	//   i.e., say there are two Turtle objects, harriet and crush... how does
	//   a method know that a call to drawSquare method is to be done on crush
	//   and not on harriet (or any other Turtle)?? 

} // this } is the end of class Turtle, put all new methods before this