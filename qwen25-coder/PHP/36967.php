header('Content-Type: text/html; charset=utf-8');\n   \n   $handle = fopen("file.txt", "r");\n   while (($line = fgets($handle)) !== FALSE) {\n       // Convert from ISO-8859-1 to UTF-8 if needed\n       echo mb_convert_encoding($line, 'UTF-8', 'ISO-8859-1');\n   }\n   fclose($handle);