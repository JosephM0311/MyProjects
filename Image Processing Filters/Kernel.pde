public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
  *This implementation only allows 3x3 kernels
  */
  public Kernel(float[][]init) {
    kernel = new float[init.length][init[0].length];
    for(int x = 0; x < init.length; x++){
      for(int y = 0; y < init[x].length; y++){
        kernel[x][y] = init[x][y];
      }
    }
  }

  /**If part of the kernel is off of the image, return black, Otherwise
  *Calculate the convolution of r/g/b separately, and return that color\
  *if the calculation for any of the r,g,b values is outside the range
  *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
  */
  color calcNewColor(PImage img, int x, int y) {
    img.loadPixels();
    color c;
    float r = 0;
    float g = 0;
    float b = 0;
      
    for(int m = -1; m < 2; m++){
      for(int n = -1; n < 2; n++){
        int xcor = x + n;
        int ycor = y + m;
        
        if(xcor < 0 || xcor >= img.width || ycor < 0 || ycor >= img.height)
          c = color(0, 0, 0);
        else
          c = img.get(xcor, ycor);
          
        r += red(c) * kernel[m + 1][n + 1];
        g += green(c) * kernel[m + 1][n + 1];
        b += blue(c) * kernel[m + 1][n + 1];
      }
    }
    
    r = constrain(r, 0, 255);
    g = constrain(g, 0, 255);
    b = constrain(b, 0, 255);
    
    //if(r > 255)
    //  r = 255;
    //if(r < 0)
    //  r = 0;
    //if(g > 255)
    //  g = 255;
    //if(g < 0)
    //  g = 0;
    //if(b > 255)
    //  b = 255;
    //if(b < 0)
    //  b = 0;
      
    return color(r, g, b);
  }

  /**Apply the kernel to the source,
  *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    for(int x = 0; x < source.width; x++) {
      for(int y = 0; y < source.height; y++){
        color c = calcNewColor(source, x, y);
        destination.set(x, y, c);
      }
    }
  }

}
