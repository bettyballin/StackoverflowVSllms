<?php\nfunction convertDocToRtf($inputFile, $outputFile) {\n    $command = escapeshellcmd("libreoffice --headless --convert-to rtf:Text --outdir /path/to/output/ " . $inputFile);\n    shell_exec($command);\n\n    // Rename the output file if necessary\n    $baseName = pathinfo($inputFile, PATHINFO_FILENAME);\n    rename("/path/to/output/{$baseName}.rtf", $outputFile);\n}\n\n$inputFilePath = '/path/to/input/document.doc';\n$outputFilePath = '/path/to/output/document.rtf';\n\nconvertDocToRtf($inputFilePath, $outputFilePath);\n\n// Now you can read the RTF file\n$docContent = file_get_contents($outputFilePath);\necho $docContent;\n?>