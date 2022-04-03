import random
import requests

response = requests.get("https://random-word-api.herokuapp.com/all")
print(response.status_code)

word_list = response.json()

randNum = random.randint(0, len(word_list) - 1)

word = word_list[randNum]

target_word = "_ " * len(word)

print(f"Word: {target_word}")

attempts = 0

while attempts < 15:
    if "_" in target_word:
        user_input = input("Enter Letter (All Lowercase): ")

        if len(user_input) == 1 and user_input.isalpha() and user_input.islower():
            index = 0

            if user_input in word:
                for x in word:
                    if user_input == x:
                        target_word = target_word[:index*2] + user_input + target_word[index*2 + 1:]
                        index += 1
                    else:
                        index += 1
            else:
                print("WRONG!")
                attempts += 1

            print(f"Word: {target_word}")
            print(f"Attempts Remaining: {15 - attempts}")
            print("----------------------------------------------------")
            print("")

        else:
            print("TRY AGAIN!!")
    else:
        print("VICTORY!!! FELLA DID NOT DIE!!")
        break
else:
    print("DAMN FELLA DIED!!")
    