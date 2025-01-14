from lxml import etree\n\n# ... (same request code as above)\n\nif response.status_code == 200:\n    # Parse the XML content using lxml\n    root = etree.fromstring(response.content)\n    \n    # Example: Accessing elements (modify according to your XML structure)\n    for element in root.xpath('//your_element'):\n        print(element.text)\nelse:\n    print(f"Failed to retrieve data: {response.status_code}")