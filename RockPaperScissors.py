import random

robot_score = 0
user_score = 0

def Shoot(user_input, robot_input):
    global robot_score
    global user_score
    if user_input == "Rock":
        order = 0
        if order + robot_input == 1:
            print("PC wins!")
            robot_score += 1
            print(f"Robot: {robot_score} , User: {user_score}")
        elif order + robot_input == 2:
            print("I win!")
            user_score += 1
            print(f"Robot: {robot_score} , User: {user_score}")
        else:
            print("Tie")
            print(f"Robot: {robot_score} , User: {user_score}")

    elif user_input == "Paper":
        order = 0
        if order + robot_input == 2:
            print("PC wins!")
            robot_score += 1
            print(f"Robot: {robot_score} , User: {user_score}")
        elif order + robot_input == 0:
            print("I win!")
            user_score += 1
            print(f"Robot: {robot_score} , User: {user_score}")
        else:
            print("Tie")
            print(f"Robot: {robot_score} , User: {user_score}")

    elif user_input == "Scissor":
        order = 0
        if order + robot_input == 0:
            print("PC wins!")
            robot_score += 1
            print(f"Robot: {robot_score} , User: {user_score}")
        elif order + robot_input == 1:
            print("I win!")
            user_score += 1
            print(f"Robot: {robot_score} , User: {user_score}")
        else:
            print("Tie")
            print(f"Robot: {robot_score} , User: {user_score}")

    else:
        print("stoopid")

while user_score < 5 and robot_score < 5:
    user_move = input("Choose Rock, Paper, or Scissor: ")

    random_num = random.randint(0, 2)
    moves = ["Rock", "Paper", "Scissor"]

    robot_move = moves[random_num]

    print(robot_move)

    robot_order = random_num

    Shoot(user_move, robot_order)

else:
    if user_score > robot_score:
        print("I AM BETTER!!")
    else:
        print("RIGGED!!")