import ctypes\nimport ctypes.util\n\nCGEventSourceSecondsSinceLastEventType = ctypes.CDLL(ctypes.util.find_library('CoreGraphics')).CGEventSourceSecondsSinceLastEventType\nCGEventSourceSecondsSinceLastEventType.restype = ctypes.c_double\nkCGAnyInputEventType = 0\n\ndef get_idle_duration():\n    return CGEventSourceSecondsSinceLastEventType(kCGAnyInputEventType)\n\nprint(f"Idle time on macOS: {get_idle_duration()} seconds")