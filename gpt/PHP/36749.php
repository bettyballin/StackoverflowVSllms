$xmlDoc = domxml_open_file("example.xml");\n$root = $xmlDoc->document_element();\n$nodes = $root->get_elements_by_tagname("tagname");\n\nforeach ($nodes as $node) {\n    echo $node->get_content();\n}