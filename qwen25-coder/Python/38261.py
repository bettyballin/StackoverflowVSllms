from lxml import etree\n\n# Assuming 'text' contains your XML data\ntext = '''<a b="value">\n    <b/>\n</a>'''\n\nroot = etree.fromstring(text)\n\n# XPath expression to find the parent node of <b> which has an attribute 'b'\nparent_with_attr_b = root.find('.//b/..[@b]')\n\nif parent_with_attr_b is not None:\n    print(etree.tostring(parent_with_attr_b, pretty_print=True).decode())\nelse:\n    print("No such parent found.")