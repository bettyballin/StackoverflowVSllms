from ctypes import *\n\n# Load the DLL\ndll = CDLL('RingBell')\n\n# Call the function\ndll.ringBell()