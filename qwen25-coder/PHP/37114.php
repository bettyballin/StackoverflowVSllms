// Load XML from a file\n$xml = simplexml_load_file('file.xml');\n\n// Parse XML from a string\n$xmlString = '<root><element>Value</element></root>';\n$xml = simplexml_load_string($xmlString);