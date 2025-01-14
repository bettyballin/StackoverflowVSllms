<?php\nfunction stripMetadata($inputFile, $outputFile) {\n    // Check if the file is a JPEG\n    $imageType = exif_imagetype($inputFile);\n    if ($imageType !== IMAGETYPE_JPEG) {\n        throw new Exception('The image is not a JPEG.');\n    }\n\n    // Attempt to remove EXIF data\n    $removeExifResult = @exif_imagetype($inputFile, true);\n    if (!$removeExifResult['APP1']) {\n        copy($inputFile, $outputFile); // Copy the original file if no metadata is found\n    } else {\n        $image = new Imagick();\n        $image->readImage($inputFile);\n        foreach ($image as $frame) {\n            $profile = $frame->getImageProfile('iptc');\n            if (!empty($profile)) {\n                $frame->removeImageProfile('iptc');\n            }\n        }\n        $image->writeImage($outputFile);\n    }\n\n    // Verify the output file size reduction\n    if (file_exists($outputFile) && filesize($outputFile) > 0) {\n        echo "Metadata removed from $inputFile and saved to $outputFile.\n";\n    } else {\n        throw new Exception('Error in removing image metadata.');\n    }\n}\n\n// Example usage:\ntry {\n    stripMetadata('input.jpg', 'output.jpg');\n} catch (Exception $e) {\n    echo 'Error: ',  $e->getMessage(), "\n";\n}\n?>