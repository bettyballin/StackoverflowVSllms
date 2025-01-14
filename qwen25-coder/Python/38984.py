import libxml2\n\nxmldoc = libxml2.parseDoc(gfile_content)\n\ndroot = xmldoc.children         # Get document root\ndchild = droot.children         # Get child nodes\n\ndef count_children(node):\n    count = 0\n    child = node.children\n    while child is not None:\n        if child.type == "element":\n            count += 1\n        child = child.next\n    return count\n\nwhile dchild is not None:\n    if dchild.type == "element":\n        print("\tAn element with", count_children(dchild), "child(ren)")\n        print("\tAnd content", repr(dchild.content))\n    dchild = dchild.next\nxmldoc.freeDoc()