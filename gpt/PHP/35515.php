<?php\n// Data to be exported\n$data = "Numéro 1";\n\n// Prepend BOM\n$bom = "\xEF\xBB\xBF";\n$output = $bom . $data;\n\n// Define the CSV file path\n$file = 'example.csv';\n\n// Write the output to the CSV file\nfile_put_contents($file, $output);\n?>