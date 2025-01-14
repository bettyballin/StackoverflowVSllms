import xml.etree.ElementTree as ET\n\ndef compare_xml(file1, file2):\n    tree1 = ET.parse(file1)\n    tree2 = ET.parse(file2)\n    \n    root1 = tree1.getroot()\n    root2 = tree2.getroot()\n    \n    return compare_elements(root1, root2)\n\ndef compare_elements(elem1, elem2):\n    if elem1.tag != elem2.tag or elem1.text != elem2.text or elem1.attrib != elem2.attrib:\n        return False\n    \n    if len(elem1) != len(elem2):\n        return False\n    \n    for child1, child2 in zip(elem1, elem2):\n        if not compare_elements(child1, child2):\n            return False\n    \n    return True\n\nfile1 = 'path/to/your/first.xml'\nfile2 = 'path/to/your/second.xml'\n\nif compare_xml(file1, file2):\n    print("The XML files are identical.")\nelse:\n    print("The XML files are different.")