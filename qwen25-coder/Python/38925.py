import serial\nimport threading\nimport sys\nimport os\n\n# Port and baud rate settings\nPORT = '/dev/ttyUSB0'\nBAUD_RATE = 9600\n\ndef read_from_port(ser):\n    while True:\n        data = ser.read(1)\n        if data:\n            print("Read: ", data, file=sys.stderr)\n            sys.stdout.buffer.write(data)\n\ndef write_to_port(ser):\n    while True:\n        data = os.read(sys.stdin.fileno(), 1024)\n        if data:\n            print("Send: ", data, file=sys.stderr)\n            ser.write(data)\n\nwith serial.Serial(PORT, BAUD_RATE) as ser:\n    reader_thread = threading.Thread(target=read_from_port, args=(ser,))\n    writer_thread = threading.Thread(target=write_to_port, args=(ser,))\n    \n    reader_thread.setDaemon(True)\n    writer_thread.setDaemon(True)\n    \n    reader_thread.start()\n    writer_thread.start()\n\n    while True:\n        pass