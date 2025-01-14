<?php\n$directory = "path/to/images/folder"; // Specify the directory containing your images\n\n// Open the directory and loop through each file\nif (is_dir($directory)) {\n    if ($dh = opendir($directory)) {\n        while (($file = readdir($dh)) !== false) {\n            // Skip current and parent directories\n            if ($file != '.' && $file != '..') {\n                $filePath = "$directory/$file";\n                \n                // Check if it's an image file\n                if (exif_imagetype($filePath)) {\n                    // Resize the image to create a thumbnail\n                    list($width, $height) = getimagesize($filePath);\n                    $newWidth = 100;\n                    $aspectRatio = $width / $height;\n                    $newHeight = $newWidth / $aspectRatio;\n\n                    $thumbnail = imagecreatetruecolor($newWidth, $newHeight);\n                    $sourceImage = imagecreatefromjpeg($filePath); // Change according to your image type\n                    imagecopyresampled($thumbnail, $sourceImage, 0, 0, 0, 0, $newWidth, $newHeight, $width, $height);\n\n                    // Output the thumbnail as a data URI\n                    ob_start();\n                    imagejpeg($thumbnail);\n                    $dataUri = 'data:image/jpeg;base64,' . base64_encode(ob_get_clean());\n                    \n                    echo '<img src="' . $dataUri . '" alt="' . htmlspecialchars($file) . '">';\n\n                    // Free up memory after displaying the thumbnail\n                    imagedestroy($sourceImage);\n                    imagedestroy($thumbnail);\n                }\n            }\n        }\n        closedir($dh);\n    }\n}\n?>