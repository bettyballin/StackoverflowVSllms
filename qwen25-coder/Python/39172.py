import xml.etree.ElementTree as ET\n\nxml = '''<node attribute1="value1" attribute2="value2" />'''\nroot = ET.fromstring(xml)\n\nattribute_names = root.attrib.keys()\nprint(attribute_names)