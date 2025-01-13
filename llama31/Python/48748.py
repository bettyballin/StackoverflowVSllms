def fizz_buzz(n):\n    """\n    Prints the FizzBuzz sequence up to n.\n    """\n    for i in range(1, n+1):\n        if i % 3 == 0 and i % 5 == 0:\n            print("FizzBuzz")\n        elif i % 3 == 0:\n            print("Fizz")\n        elif i % 5 == 0:\n            print("Buzz")\n        else:\n            print(i)\n\n# Example usage:\nfizz_buzz(20)