function countLines($file) {\n    $handle = fopen($file, 'r');\n    $count = 0;\n    while (!feof($handle)) {\n        fgets($handle);\n        $count++;\n    }\n    fclose($handle);\n    return $count;\n}\n\n// usage:\n$file = 'large_data_file.txt';\n$totalRows = countLines($file);