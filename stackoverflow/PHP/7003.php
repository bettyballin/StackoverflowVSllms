<?php                                              \n/*\nResizes an image and converts it to PNG returning the PNG data as a string\n*/\nfunction imageToPng($srcFile, $maxSize = 100) {  \n    list($width_orig, $height_orig, $type) = getimagesize($srcFile);        \n\n    // Get the aspect ratio\n    $ratio_orig = $width_orig / $height_orig;\n\n    $width  = $maxSize; \n    $height = $maxSize;\n\n    // resize to height (orig is portrait) \n    if ($ratio_orig < 1) {\n        $width = $height * $ratio_orig;\n    } \n    // resize to width (orig is landscape)\n    else {\n        $height = $width / $ratio_orig;\n    }\n\n    // Temporarily increase the memory limit to allow for larger images\n    ini_set('memory_limit', '32M'); \n\n    switch ($type) \n    {\n        case IMAGETYPE_GIF: \n            $image = imagecreatefromgif($srcFile); \n            break;   \n        case IMAGETYPE_JPEG:  \n            $image = imagecreatefromjpeg($srcFile); \n            break;   \n        case IMAGETYPE_PNG:  \n            $image = imagecreatefrompng($srcFile);\n            break; \n        default:\n            throw new Exception('Unrecognized image type ' . $type);\n    }\n\n    // create a new blank image\n    $newImage = imagecreatetruecolor($width, $height);\n\n    // Copy the old image to the new image\n    imagecopyresampled($newImage, $image, 0, 0, 0, 0, $width, $height, $width_orig, $height_orig);\n\n    // Output to a temp file\n    $destFile = tempnam();\n    imagepng($newImage, $destFile);  \n\n    // Free memory                           \n    imagedestroy($newImage);\n\n    if ( is_file($destFile) ) {\n        $f = fopen($destFile, 'rb');   \n        $data = fread($f);       \n        fclose($f);\n\n        // Remove the tempfile\n        unlink($destFile);    \n        return $data;\n    }\n\n    throw new Exception('Image conversion failed.');\n}