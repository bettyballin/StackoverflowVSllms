$data = [['Name', 'Email'], ['John Doe', 'john@example.com']];\n\n   $fp = fopen('path/to/file.csv', 'w');\n   foreach ($data as $fields) {\n       fputcsv($fp, $fields);\n   }\n   fclose($fp);