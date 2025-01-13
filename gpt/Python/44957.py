import RPi.GPIO as GPIO\nimport time\n\n# Setup\nGPIO.setmode(GPIO.BCM)  # Use BCM pin numbering\ninput_pin = 18          # Replace with your actual GPIO pin number\nGPIO.setup(input_pin, GPIO.IN)\n\ntry:\n    while True:\n        # Read input from GPIO pin\n        input_state = GPIO.input(input_pin)\n        if input_state == GPIO.HIGH:\n            print("Input signal detected")\n        else:\n            print("No input signal")\n        time.sleep(0.5)  # Wait for 0.5 seconds\n\nexcept KeyboardInterrupt:\n    print("Quitting...")\n\nfinally:\n    GPIO.cleanup()  # Clean up GPIO settings