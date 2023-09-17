int currentKernel = 0;
String[] names = new String[]{
  "Identity", "Blur", "Sharpen",
  "Outline", "Left Sobel", "Right Sobel",
  "Top Sobel", "Emboss"
};

Kernel[] kernels = new Kernel[] {
  new Kernel( new float[][] {
    {0, 0, 0},
    {0, 1, 0},
    {0, 0, 0}
  }) ,
  new Kernel( new float[][] {
    {.111, .111, .111},
    {.111, .111, .111},
    {.111, .111, .111}
  }) ,
  new Kernel( new float[][] {
    {0, -1, 0},
    {-1, 5, -1},
    {0, -1, 0}
  }) ,
  new Kernel( new float[][] {
    {-1, -1, -1},
    {-1, 8, -1},
    {-1, -1, -1}
  }) ,
  new Kernel( new float[][] {
    {1, 0, -1},
    {2, 0, -2},
    {1, 0, -1}
  }) ,
  new Kernel( new float[][] {
    {-1, 0, 1},
    {-2, 0, 2},
    {-1, 0, 1}
  }) ,
  new Kernel( new float[][] {
    {1, 2,  1},
    {0, 0, 0},
    {-1, -2, -1}
  }),
  new Kernel( new float[][] {
    {-2, -1,  0},
    {-1, 1, 1},
    {0, 1, 2}
  })
};

PImage car;
PImage output;

void setup(){
  size(1450,500);
  car = loadImage("redcar.png");
  output = car.copy();
  
  //Kernel k = new Kernel( new float[][] {
  //  {-1, -1, -1},
  //  {-1, 8, -1},
  //  {-1, -1, -1}
  //} );
  //Kernel k2 = new Kernel( new float[][] {
  //  {.11, .11, .11},
  //  {.11, .11, .11},
  //  {.11, .11, .11}
  //} );
  //k.apply(car,output);
  //image(car,0,0);
  //image(output,car.width,0);
  
}

void draw() {
  textSize(20);
  fill(0);
  kernels[currentKernel].apply(car, output);
  image(car,0,0);
  image(output,car.width,0);
  text("Current Kernel: " + names[currentKernel], 5, 20);
}

void keyPressed(){
  if(keyCode == '1')
    currentKernel = 0;
  else if (keyCode == '2')
    currentKernel = 1;
  else if (keyCode == '3')
    currentKernel = 2;
  else if (keyCode == '4')
    currentKernel = 3;
  else if (keyCode == '5')
    currentKernel = 4;
  else if (keyCode == '6')
    currentKernel = 5;
  else if (keyCode == '7')
    currentKernel = 6;
  else if (keyCode == '8')
    currentKernel = 7;
}
