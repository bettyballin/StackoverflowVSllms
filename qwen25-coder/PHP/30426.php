<?php\n$pdfFilename = 'document.pdf';\n$imageOutputPath = 'output.jpg';\n\ntry {\n    $imagick = new \Imagick(realpath($pdfFilename) . '[' . 0 . ']'); // Page number starts from 0\n    $imagick->setImageFormat('jpg');\n    header("Content-Type: image/jpeg");\n    file_put_contents($imageOutputPath, $imagick);\n    echo "Conversion successful. Image saved as $imageOutputPath";\n} catch (Exception $e) {\n    echo 'Error: ' . $e->getMessage();\n}\n?>