$xml_parser = xml_parser_create();\n\nxml_parser_set_option($xml_parser, XML_OPTION_CASE_FOLDING, false);\nxml_set_element_handler($xml_parser, "startTag", "endTag");\nxml_set_character_data_handler($xml_parser, "contents");\n\nfunction startTag($parser, $name, $attrs) {\n    if ($name == 'data') {\n        xml_set_element_handler($parser, 'startData', 'endData');\n    }\n}\n\nfunction startData($parser, $name, $attrs) {\n    // do nothing\n}\n\nfunction endData($parser, $name) {\n    xml_set_element_handler($parser, 'startTag', 'endTag');\n}\n\n$document = file_get_contents("php://input");                  \nxml_parse($xml_parser, $document);\nxml_parser_free($xml_parser);