<?php\n// Define the path to the input Speex file and the output MP3 file\n$inputFile = 'input.spx';\n$outputFile = 'output.mp3';\n\n// Define the FFmpeg command\n$command = "ffmpeg -i " . escapeshellarg($inputFile) . " " . escapeshellarg($outputFile);\n\n// Execute the command\nexec($command, $output, $return_var);\n\n// Check if the conversion was successful\nif ($return_var === 0) {\n    echo "Conversion successful!";\n} else {\n    echo "Conversion failed!";\n}\n?>