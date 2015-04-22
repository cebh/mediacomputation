package mediacomputation;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /**
   * Removes the red from the entire Picture by iterating through every
   * Pixel in the Picture and setting its red component to 0.
   */
  public void removeRed()
  {
    int width = getWidth();
    int height = getHeight();
    int pixelCount = width * height; // number of Pixels
    int x = 0, y = 0;
    // go through all pixelCount Pixels, one at a time…
    //    set the Pixel’s red color to 0 in order to remove it
    
//    for (int i=0; i < pixelCount; i++) 
    
    int i=0;
    while (i < pixelCount)
    {
      // body
      x = i % width; // one row = all of the columns that create the width of the picture
      y = i / width;
      Pixel aDot = getPixel(x, y);
      aDot.setRed(0);
      
      i++;
    }
  }
  
  public void keepGreen()
  {

  }
    
  public void makeRGBRows()
  {

  }
  
  
  public void makeRGBColumns()
  {

  }

  public Picture crop(int leftX, int topY, int regionWidth, int regionHeight)
  {
  	int x1, y1, x2, y2;
  	if(leftX + regionWidth > this.getWidth()) {
  		regionWidth = this.getWidth() - leftX;
  	}
  	if(topY + regionHeight > this.getHeight()) {
  		regionHeight = this.getHeight() - topY;
  	}
  	Picture croppedPicture = new Picture(regionWidth, regionHeight);
  	int regionPixelCount = regionWidth*regionHeight;
  	for(int i = 0; i < regionPixelCount; i++)
  	{
  		x1 = i % regionWidth + leftX;
  		y1 = i / regionWidth + topY;
  		x2 = i % regionWidth;
  		y2 = i / regionWidth;
  		Pixel newDot = new Pixel(croppedPicture, x2, y2);
  		Pixel aDot = new Pixel(this,x1,y1);
  		Color col = aDot.getColor();
  		newDot.setColor(col);

  	}
  	return croppedPicture;
  }
  
  public void horizontalMirror(int leftX, int topY, int regionWidth, int regionHeight)
  {
  	  if(leftX < 0) {
  		  leftX = 0;
  	  }
  	  if(topY < 0) {
  		  topY = 0;
  	  }
  	  if(leftX + regionWidth > this.getWidth()) {
  		  regionWidth = this.getWidth() - leftX;
  	  }
  	  if(topY + regionHeight > this.getHeight()) {
  		  regionHeight = this.getHeight() - topY;
  	  }
  	  int x, y;
  	  int pixelCount = regionWidth*regionHeight/2;
  	  for(int i = 0; i < pixelCount; i++) {
    	  x = i % regionWidth + leftX;
    	  y = i / regionWidth + topY;
  		  Pixel aDot = new Pixel(this, x, y);
  		  Pixel mirroredDot = new Pixel(this, x, topY + regionHeight - (y - topY) - 1);
  		  mirroredDot.setColor(aDot.getColor());
  	  }
  }

  public void horizontalMirror()
  {
  	  this.horizontalMirror(0, 0, this.getWidth(), this.getHeight());
  }

  public void verticalMirror(int leftX, int topY, int regionWidth, int regionHeight)
  {
  	  if(leftX < 0) {
  		  leftX = 0;
  	  }
  	  if(topY < 0) {
  		  topY = 0;
  	  }
  	  if(leftX + regionWidth > this.getWidth()) {
  		  regionWidth = this.getWidth() - leftX;
  	  }
  	  if(topY + regionHeight > this.getHeight()) {
  		  regionHeight = this.getHeight() - topY;
  	  }
  	  int x, y;
  	  int pixelCount = regionWidth*regionHeight/2;
  	  for(int i = 0; i < pixelCount; i++) {
    	  x = i / regionHeight + leftX;
    	  y = i % regionHeight + topY;
  		  Pixel aDot = new Pixel(this, x, y);
  		  Pixel mirroredDot = new Pixel(this, (leftX + regionWidth - (x - leftX) - 1), y);
  		  mirroredDot.setColor(aDot.getColor());
  	  }
  }

  public void verticalMirror()
  {
  	  this.verticalMirror(0, 0, this.getWidth(), this.getHeight());
  }
  
} // this } is the end of class Picture, put all new methods before this
