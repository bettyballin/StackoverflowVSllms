from lxml import etree\n\n# Sample XML data\nxml_data = """\n<library>\n    <book>\n        <chapter>Chapter 1 of Book 1</chapter>\n    </book>\n    <book>\n        <chapter>Chapter 1 of Book 2</chapter>\n    </book>\n</library>\n"""\n\n# Parse the XML\nroot = etree.fromstring(xml_data)\n\n# Function to get absolute XPath for a node\ndef get_absolute_xpath(node, parent_path=""):\n    if node is root:\n        return f"/{node.tag}"\n    else:\n        index = node.getparent().index(node) + 1  # XPath uses 1-based indexing\n        path = f"{parent_path}/{node.tag}[{index}]"\n        return get_absolute_xpath(node.getparent(), path)\n\n# Find all chapters and print their absolute XPaths\nfor chapter in root.xpath('//chapter'):\n    absolute_path = get_absolute_xpath(chapter)\n    print(absolute_path)