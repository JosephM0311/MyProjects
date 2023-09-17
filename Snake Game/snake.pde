// worked with Timothy Young (pd 1)

/**
 * SNAKE GAME
 * Rules:
 *     Eat the food
 *     Do not bite your own tail
 *     Do not hit a wall
 * Specifications:
 *     The snake grows when eat food
 *     The speed increases when the snake grows
 *     Food is displayed randomly
 */

// global variables
ArrayList<PVector> snake = new ArrayList<PVector>(); // snake body (not included the head)
PVector pos; // snake position (position of the head)
StringList mode_list = new StringList(new String[] {"border", "no_border"}); // if you implement both functionalities
int mode_pos = 1; // mode 1 by default - if hits wall wraps around
String actual_mode = mode_list.get(mode_pos); // current mode name
PVector food; // food position

PVector dir = new PVector(1, 0); // snake direction (up, down, left right)

int size = 40; // snake and food square size
int w, h; // how many snakes can be allocated

int spd = 20; // reverse speed (smaller spd will make the snake move faster)
int len = 4; // snake body

void setup() {
  size(1080, 720);
  w = width/size;
  h = height/size;


  pos = new PVector(w/2, h/2); // Initial snake position
  newFood(); // create 2D vector

  noStroke();
  fill(0);
}

void draw() {
  background(200);
  textSize(20);
  text("Mode: " + mode_list.get(mode_pos), 10, 20);
  fill(0, 255, 0);

  drawSnake();
  drawFood();

  // update snake if frameCount is a multiple of spd which is 20 at the begining
  if (frameCount % spd == 0) {
    updateSnake();
  }
}

// draw the food item (square) which size is tha variable size
void drawFood() {
  fill(255, 0, 0);
  square(food.x * size, food.y * size, size);
}

// declare a new pVector (random) for food
void newFood() {
  food = new PVector(int(random(w)), int(random(h)));
}

// draw snake, consider the snake array size (each square of size size) + square of the current pos
void drawSnake() {
  square(pos.x * size, pos.y * size, size); // head
  for (int i = 0; i < snake.size(); i++) {
    square(snake.get(i).x * size, snake.get(i).y * size, size);
  }
}

void updateSnake() {
  //Add current position to snake ArrayList
  snake.add(0, new PVector(pos.x, pos.y));
  //Check the size of snake. Remove some items from snake ArrayList if needed
  while(snake.size() > len) {
   snake.remove(snake.size() - 1);
  }
  //Calculate new position of snake (head)
  pos = new PVector(pos.x + dir.x, pos.y + dir.y);
  //If snake (head) hits food, add +1 to the snake size and create a new food
  if(pos.x == food.x && pos.y == food.y){
    len++;
    spd--;
    newFood();
  }
  //If snake (head) eat itself, gameover, reset()
  for(int i = 0; i < snake.size(); i++) {
    if(pos.x == snake.get(i).x && pos.y == snake.get(i).y)
      reset();
  }

  //If mode 'no_border', snake is out of screen, wraps around
  if(mode_pos == 1){
    if(pos.x >= w)
      pos = new PVector(0, pos.y);
    else if(pos.x < 0)
      pos = new PVector(w - 1, pos.y);
    else if(pos.y >= h)
      pos = new PVector(pos.x, 0);
    else if(pos.y < 0)
      pos = new PVector(pos.x, h - 1);
  }
  //If mode 'border', when snake hit a border, gameover, reset()
  else if(mode_pos == 0){
    if(pos.x >= w || pos.x < 0 || pos.y >= h || pos.y < 0)
      reset();
  }
}

void reset() {
  spd = 20;
  len = 5;
  pos = new PVector(w/2, h/2);
  dir = new PVector(1, 0);
  newFood();
  snake = new ArrayList<PVector>();
}

void keyPressed() {
  // if UP is pressed => dir = new PVector(...)
  // same thing for DOWN, LEFT, RIGHT
  if (key == CODED) {
    if (keyCode == UP && dir.y == 0) {
      dir = new PVector(0, -1);
    } else if (keyCode == DOWN && dir.y == 0) {
      dir = new PVector(0, 1);
    } else if (keyCode == LEFT && dir.x == 0) {
      dir = new PVector(-1, 0);
    } else if (keyCode == RIGHT && dir.x == 0) {
      dir = new PVector(1, 0);
    }
  }
  // if '+' is pressed, increase the size of the squares (and recalculate w and h)
  if (key == '+' || key == '=') {
      size++;
      w = width/size;
      h = height/size;
  }
   
  // same thing for '-'
  if (key == '-' || key == '_') {
      size--;
      w = width/size;
      h = height/size;
     }
  // when 'm' is pressed, change the mode -> ONLY IF YOU IMPLEMENT BOTH MODES
  if(key == 'm' || key == 'M') {
    if(mode_pos == 0)
      mode_pos = 1;
    else if(mode_pos == 1)
      mode_pos = 0;
  }
}
