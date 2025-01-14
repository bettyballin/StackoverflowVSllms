<?php\nfunction createTarFromDirectory($sourceDir, $outputTarFile) {\n    try {\n        // Ensure source directory ends with a slash\n        $sourceDir = rtrim($sourceDir, '/') . '/';\n\n        // Create a new PharData object\n        $phar = new PharData($outputTarFile);\n\n        // Recursively add directory contents to the tar archive\n        $phar->buildFromDirectory($sourceDir);\n\n        // Optionally compress the archive to tar.gz (uncomment if needed)\n        // $phar->compress(Phar::GZ);\n\n        echo "Tar file created successfully at: $outputTarFile\n";\n    } catch (Exception $e) {\n        echo "Error creating tar file: " . $e->getMessage() . "\n";\n    }\n}\n\n// Example usage:\n$sourceDir = '/path/to/source/directory';\n$outputTarFile = '/path/to/output/archive.tar';\n\ncreateTarFromDirectory($sourceDir, $outputTarFile);\n?>