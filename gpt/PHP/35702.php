<?php\n$file = 'largefile.zip';\n$chunk_size = 2 * 1024 * 1024; // 2MB\n$handle = fopen($file, 'rb');\n$part = 1;\n\nwhile (!feof($handle)) {\n    $chunk = fread($handle, $chunk_size);\n    $chunk_file = $file . '.part' . $part;\n    file_put_contents($chunk_file, $chunk);\n    $part++;\n}\n\nfclose($handle);\n?>