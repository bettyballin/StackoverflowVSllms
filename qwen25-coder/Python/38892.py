import time\n\ndef main():\n    # Your bot initialization and run code here\n    print("Bot started")\n    while True:\n        # Simulate some work your bot does\n        time.sleep(5)  # Replace with actual bot logic\n\nif __name__ == "__main__":\n    while True:\n        try:\n            main()\n        except Exception as e:\n            print(f"An error occurred: {e}. Restarting...")\n            time.sleep(10)  # Delay before restarting, if necessary