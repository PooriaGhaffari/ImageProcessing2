package imageProcess;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;

  
public class ImageProcessing 
{
    public static void main(String args[])
        throws IOException
    {
        // width of the image
        int width = 700;
  
        // height of the image
        int height = 600;
  
        // For storing image in RAM
        BufferedImage image = null;
  
        // READ IMAGE
        try {
            File input_file = new File(
                "/Users/pooria/Desktop/pride-rainbow.gif");
  
            // image file path create an object of
            // BufferedImage type and pass as parameter the
            // width,  height and image int
            // type. TYPE_INT_ARGB means that we are
            // representing the Alpha , Red, Green and Blue
            // component of the image pixel using 8 bit
            // integer value.
  
            
            image = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_ARGB);
  
            // Reading input file
            image = ImageIO.read(input_file);
  
            System.out.println("Reading complete.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }

        
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
              int p = image.getRGB(x,y);

              int a = (p>>24)&0xff;
              int g = (p>>8)&0xff;

              //set new RGB
              p = (a<<24) | (0<<16) | (g<<8) | 0;

              image.setRGB(x, y, p);
            }
          }
        	
  
      
        
        // WRITE IMAGE
        try {
            // Output file path
            File output_file = new File(
                "/Users/pooria/Desktop/pride-rainbow-output.gif");
  
            // Writing to file taking type and path as
            ImageIO.write(image, "png", output_file);
  
            System.out.println("Writing complete.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    } 
} 
	
	
	
	
	
	
	
	

