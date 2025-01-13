import random\nimport time\n\ndef leader_election(people):\n    numbers = {}\n    for person in people:\n        numbers[person] = random.randint(0, 100)\n        print(f"{person} generated number: {numbers[person]}")\n    \n    time.sleep(1)  # wait for 1 second\n    \n    winner = min(numbers, key=numbers.get)\n    print(f"{winner} wins and does the task!")\n    \n    # winner announces they're doing the task\n    print(f"{winner} says: I'm doing it!")\n    \n    # others back off\n    for person in people:\n        if person != winner:\n            print(f"{person} says: Okay, I'll back off.")\n\npeople = ["Alice", "Bob", "Charlie"]\nleader_election(people)