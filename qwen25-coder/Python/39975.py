import xml.etree.ElementTree as ET\n\ndef get_inner_xml(element):\n    # Start with the text of the current element if it exists\n    inner_text = element.text or ''\n    \n    # Add the serialized string of each child, including subtags and their text/content\n    for child in element:\n        inner_text += ET.tostring(child, encoding='unicode')\n        \n        # Also add the tail text of each child if it exists\n        inner_text += child.tail or ''\n    \n    return inner_text\n\n# Example usage\nxml_data = '<p>blah <b>bleh</b> blih</p>'\nroot = ET.fromstring(xml_data)\n\ninner_content = get_inner_xml(root)\nprint(inner_content)  # Output: blah <b>bleh</b> blih