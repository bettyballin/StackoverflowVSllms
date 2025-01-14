<?php\nfunction convertToPDF($inputFile, $outputFile) {\n    // Command to convert the document to PDF using LibreOffice\n    $command = escapeshellcmd("libreoffice --headless --convert-to pdf:writer_pdf_Export '$inputFile' --outdir '/path/to/output/directory/'");\n    \n    // Execute the command\n    shell_exec($command);\n\n    // Rename the output file if necessary (LibreOffice might generate it with a different name)\n    $generatedPDF = basename(pathinfo($inputFile, PATHINFO_FILENAME)) . '.pdf';\n    rename("/path/to/output/directory/$generatedPDF", "/path/to/output/directory/$outputFile");\n\n    return file_exists("/path/to/output/directory/$outputFile");\n}\n\n// Replace 'example.doc' with your uploaded document filename and set the correct output path.\n$inputDocPath = '/path/to/input/example.doc';\n$outputPdfPath = '/path/to/output/example.pdf';\n\nif (convertToPDF($inputDocPath, basename($outputPdfPath))) {\n    echo "Document has been converted to PDF successfully.";\n} else {\n    echo "An error occurred during the conversion process.";\n}\n?>