// Convert each string from ISO-8859-1 to UTF-8\n$title = mb_convert_encoding($row["title"], 'UTF-8', 'ISO-8859-1');\n$intro = mb_convert_encoding($row["intro"], 'UTF-8', 'ISO-8859-1');\n\n// Ensure the XML header specifies UTF-8 encoding\necho '<?xml version="1.0" encoding="UTF-8"?>' . "\n";