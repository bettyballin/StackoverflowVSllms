# Using XPath to find elements\n    elements = root.xpath("//element[@key='value']")\n    for elem in elements:\n        print(elem.text)  # Outputs the text of elements with the specified attribute