import io\nimport xml.etree.ElementTree as ET\n\n# XML string to be validated\nxml_string = """<?xml version='1.0'?>\n<note>\n  <to>Tove</to>\n  <from>Jani</from>\n  <heading>Reminder</heading>\n  <body>Don't forget me this weekend!</body>\n</note>\n"""\n\n# DTD file\ndtd_file = "note.dtd"\n\n# Parse the DTD file\nwith open(dtd_file, 'r') as f:\n    dtd_string = f.read()\n\n# Create an ElementTree object from the XML string\nroot = ET.fromstring(xml_string)\n\n# Validate the XML against the DTD\ntry:\n    ET.DTD(io.StringIO(dtd_string)).assertValid(root)\n    print("XML is valid")\nexcept ET.ParseError as e:\n    print("XML is not valid:", e)