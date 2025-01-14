import xml.etree.ElementTree as ET\n\n# Sample XML string\nxml_data = '''<books>\n    <book>\n        <title>Python Programming</title>\n        <author>John Doe</author>\n    </book>\n    <book>\n        <title>Learning XML</title>\n        <author>Jane Smith</author>\n    </book>\n</books>'''\n\n# Parse the XML data\nroot = ET.fromstring(xml_data)\n\n# Iterate over each book in the XML\nfor book in root.findall('book'):\n    title = book.find('title').text\n    author = book.find('author').text\n    print(f'Title: {title}, Author: {author}')