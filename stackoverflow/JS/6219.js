nodeList = {}\nenumerateNodes(rootNode, nodeList);\n\nfunction enumerateNodes(node, nodeList) {\n   nodeList += node;\n   foreach ( childnode in node.children ) {\n       enumerateNodes(childnode, nodeList);\n   }\n}