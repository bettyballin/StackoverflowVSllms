$string = "This is a string with special characters: &nbsp; &amp; &copy;";\n// Use strip_tags to remove HTML tags\n$stripped_string = strip_tags($string);\n// Use html_entity_decode to convert HTML entities to their corresponding characters\n$clean_string = html_entity_decode($stripped_string, ENT_QUOTES | ENT_XML1, 'UTF-8');\n\necho $clean_string;