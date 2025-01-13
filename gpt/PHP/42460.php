<?php\n// Open the file for reading and writing\n$filename = date("Y-m-d") . ".txt";\n$file = fopen($filename, "r+") or exit("Unable to open file!");\n\n// Read the existing contents of the file\n$existingContent = fread($file, filesize($filename));\n\n// Check if there is a new text to add\nif (!empty($_POST["lastname"])) {\n    // Prepend the new text to the existing content\n    $newContent = $_POST["lastname"] . "\n" . $existingContent;\n    \n    // Move the file pointer to the beginning of the file\n    rewind($file);\n    \n    // Write the new content back to the file\n    fwrite($file, $newContent);\n}\n\n// Close the file\nfclose($file);\n?>