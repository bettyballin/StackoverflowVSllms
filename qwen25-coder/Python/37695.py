import board\n  from adafruit_fingerprint import Adafruit_Fingerprint\n\n  uart = busio.UART(board.TX, board.RX, baudrate=57600)\n\n  finger = Adafruit_Fingerprint(uart)\n  \n  def get_num():\n      """Helper function to take an input and convert it into a number\n      """\n      input_var = ''\n      while True:\n          try:\n              return int(input_var)\n          except ValueError:\n              print("Invalid Input. Please enter a numeric value: ", end="")\n\n  while finger.get_templates() != adafruit_fingerprint.OK:\n      pass\n\n  if finger.count_templates() != 0:\n      print("There are templates stored!")\n  else:\n      print("The sensor has no fingerprints stored for enrollment...")