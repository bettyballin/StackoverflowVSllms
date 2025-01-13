// Function to handle start tags\nfunction first($parser, $name, $attribs) {\n    global $trigger;\n    if ($name == "PRODUCTSIDEID" || $name == "PRODUCTID") {\n        $trigger = 1;\n    }\n}\n\n// Function to handle character data\nfunction xml($parser, $data) {\n    global $trigger;\n    global $productspecs;\n    global $count;\n    global $type_check;\n    if ($trigger == 1) {\n        if ($type_check == "sideid" || $type_check == "productid") {\n            $productspecs[$count] = $data;\n            $count++;\n        }\n        $trigger = 0;\n    }\n}\n\n// Function to parse Product ID from Product Sides\nfunction getProductSpecs($xml, $type) {\n    // Setup array\n    global $productspecs;\n    global $count;\n    $productspecs = [];\n    $count = 0;\n    global $type_check;\n    $type_check = $type;\n\n    // Parse the XML\n    // Create the parser\n    if (!($xmlparser = xml_parser_create())) { \n        die("Cannot create name list parser");\n    }\n\n    // Call the handler functions\n    xml_set_element_handler($xmlparser, "first", "");\n    \n    // Call the data handler\n    xml_set_character_data_handler($xmlparser, "xml");\n    \n    // Parse the XML data\n    xml_parse($xmlparser, $xml);\n\n    // Clear parser\n    xml_parser_free($xmlparser);\n\n    // Return the array\n    return $productspecs;\n}