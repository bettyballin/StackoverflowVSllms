$xml = simplexml_load_file('xml.xml');\n$root = $xml->root;\nforeach ($root as $tag) {\n    $subChild = $tag->child;\n    // extract values and loop again if needed\n}