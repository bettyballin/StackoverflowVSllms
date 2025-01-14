<?php\nfunction extractLayersFromPsd($psdFilePath) {\n    // Create an Imagick object with the PSD file path\n    $imagick = new Imagick($psdFilePath);\n\n    // Enable reading of all layers\n    $imagick->setIteratorIndex(0);\n    do {\n        // Extract the layer image\n        $image = $imagick->getImageBlob();\n\n        // Define the output file name based on the layer index\n        $outputFileName = 'layer_' . $imagick->getIteratorIndex() . '.png';\n\n        // Write the layer to a file\n        file_put_contents($outputFileName, $image);\n\n        echo "Saved: $outputFileName\n";\n    } while ($imagick->nextImage());\n\n    // Clean up\n    $imagick->clear();\n    $imagick->destroy();\n}\n\n// Example usage\nextractLayersFromPsd('path/to/your/file.psd');\n?>