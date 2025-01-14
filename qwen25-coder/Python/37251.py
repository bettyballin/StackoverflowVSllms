import serial\n\ndef read_magnetic_card():\n    try:\n        # Initialize serial connection\n        ser = serial.Serial('COM1', 9600, timeout=1)\n        \n        print("Waiting for card swipe...")\n        \n        while True:\n            if ser.in_waiting > 0:\n                raw_data = ser.readline().decode('utf-8').strip()\n                print(f"Card Data: {raw_data}")\n                break\n        \n        # Close the serial connection\n        ser.close()\n    except Exception as e:\n        print(f"Error: {e}")\n\nif __name__ == "__main__":\n    read_magnetic_card()