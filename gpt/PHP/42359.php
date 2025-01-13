<?php\n   $filePath = 'path/to/your/document.doc';\n   $outputPath = 'path/to/output/document.pdf';\n   \n   $command = "libreoffice --headless --convert-to pdf " . escapeshellarg($filePath) . " --outdir " . escapeshellarg(dirname($outputPath));\n   shell_exec($command);\n   \n   if (!file_exists($outputPath)) {\n       echo "Error converting the .doc file to PDF.";\n   } else {\n       echo "File successfully converted to PDF.";\n   }\n   ?>