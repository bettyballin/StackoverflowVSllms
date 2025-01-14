from io import StringIO\nfrom lxml import etree\n\n# Your XML string\nxml_string = """<?xml version="1.0" encoding="UTF-8"?>\n<!DOCTYPE root SYSTEM "example.dtd">\n<root>\n    <element>Content</element>\n</root>\n"""\n\n# Parse the DTD from a file or string\nwith open('example.dtd') as dtd_file:\n    dtd_content = dtd_file.read()\n\ndtd = etree.DTD(StringIO(dtd_content))\n\n# Parse the XML string\nparser = etree.XMLParser(dtd_validation=True)\nxml_doc = etree.parse(StringIO(xml_string), parser)\n\n# Validate the document\nif dtd.validate(xml_doc):\n    print("XML is valid.")\nelse:\n    print("XML is invalid.")\n    print(dtd.error_log.filter_from_errors())