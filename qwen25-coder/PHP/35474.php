// Example of handling XML with PHP's SimpleXML\n   $xml = simplexml_load_string('<note><to>Tove</to></note>');\n   echo (string)$xml->to;