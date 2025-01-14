<?php\n$file = 'data.txt';\n\n// Open the file for reading and writing\n$fp = fopen($file, 'c+');\n\nif (flock($fp, LOCK_EX)) {\n    // Lock acquired\n\n    // Read the file content\n    $contents = fread($fp, filesize($file));\n\n    // Modify the file content\n    $contents .= "New data\n";\n\n    // Move the file pointer back to the start of the file\n    fseek($fp, 0);\n\n    // Write the new content to the file\n    fwrite($fp, $contents);\n\n    // Truncate the file to the current length\n    ftruncate($fp, ftell($fp));\n\n    // Unlock the file\n    flock($fp, LOCK_UN);\n\n} else {\n    // Couldn't get the lock\n    echo "Could not lock the file!";\n}\n\nfclose($fp);\n?>