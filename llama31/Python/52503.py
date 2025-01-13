import xml.etree.ElementTree as ET\n\ndef validate_xhtml(xhtml_string):\n    try:\n        ET.fromstring(xhtml_string)\n    except ET.ParseError as e:\n        print("Validation error:", e)\n        return False\n    return True\n\nxhtml_string = "<html xmlns='http://www.w3.org/1999/xhtml'><head><title>Test</title></head><body>Hello, World!</body></html>"\nif validate_xhtml(xhtml_string):\n    print("XHTML is valid")\nelse:\n    print("XHTML is not valid")