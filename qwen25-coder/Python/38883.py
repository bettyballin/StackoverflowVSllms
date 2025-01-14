import time\n\ndef primes_between(start, end):\n    primes = []\n    for num in range(max(2, start), end + 1):\n        if all(num % i != 0 for i in range(2, int(num ** 0.5) + 1)):\n            primes.append(num)\n            print(num)\n            time.sleep(1)  # Sleep for one second between prints\n    return primes\n\ndef run_for_duration(current_time, duration):\n    while (time.time() - current_time) < duration:\n        pass  # Placeholder for the actual computation logic\n\ntry:\n    start_time = time.time()\n    target_duration = 30  # Run for first 30 seconds\n    fibonacci_start = 0\n    \n    while True:\n        # Generate Fibonacci sequence until a key is pressed or duration ends\n        run_for_duration(start_time, target_duration)\n        \n        # After the initial period, you can decide to extend the duration\n        extend_duration = input("Extend duration? (y/n): ")\n        if extend_duration.lower() == 'y':\n            additional_time = int(input("Enter additional time in seconds: "))\n            start_time += additional_time  # Start new timer from now + extend_time seconds ago\n        else:\n            break\n\nexcept KeyboardInterrupt:\n    print("\nStopped by user")