if __name__ == "__main__":\n    getList = input("Enter numbers separated by commas:\n").strip()\n    listOfBubbles = getList.split(',')\n    print(listOfBubbles)\n    \n    cleanedList = []\n    \n    for k in listOfBubbles:\n        stripped_k = k.strip()\n        if stripped_k:  # Check if the string is not empty\n            try:\n                int_value = int(stripped_k)\n                cleanedList.append(int_value)\n                print(f"{int_value} is okay!")\n            except ValueError as ex:\n                print(f"deleting '{stripped_k}'")\n    \n    print(repr(cleanedList))