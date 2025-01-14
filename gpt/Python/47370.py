from lxml import etree\nfrom io import StringIO\n\ndoc = """<?xml version="1.0" encoding="UTF-8"?>\n<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" \n                      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">\n<html xmlns="http://www.w3.org/1999/xhtml">\n   <head>\n        <title>hi there</title>\n    </head>\n    <body>\n        <img class="foo" src="bar.png"/>\n    </body>\n</html>"""\n\ntree = etree.parse(StringIO(doc))\nroot = tree.getroot()\n\n# Define the namespace map\nnamespaces = {'x': 'http://www.w3.org/1999/xhtml'}\n\n# Use the namespace in the XPath\nimg_elements = root.xpath('//x:img', namespaces=namespaces)\nprint(img_elements)  # Output: [<Element {http://www.w3.org/1999/xhtml}img at 0x...>]