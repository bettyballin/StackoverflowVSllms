import threading\n\ndef my_function():\n    print("Function is called")\n\n# Create threads\nthread1 = threading.Thread(target=my_function)\nthread2 = threading.Thread(target=my_function)\n\n# Start threads\nthread1.start()\nthread2.start()\n\n# Wait for both threads to complete\nthread1.join()\nthread2.join()