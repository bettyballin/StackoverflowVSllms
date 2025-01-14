<?php\nfunction createRoundedCorners($imagePath, $cornerRadius) {\n    // Load the image\n    $image = imagecreatefromstring(file_get_contents($imagePath));\n    if ($image === false) {\n        throw new Exception('Failed to load image.');\n    }\n\n    // Get image dimensions\n    $width = imagesx($image);\n    $height = imagesy($image);\n\n    // Create a new true color image with transparency\n    $newImage = imagecreatetruecolor($width, $height);\n    imagesavealpha($newImage, true);\n    $transColor = imagecolorallocatealpha($newImage, 0, 0, 0, 127);\n    imagefill($newImage, 0, 0, $transColor);\n\n    // Draw rounded corners\n    $cornerImage = imagecreatetruecolor($cornerRadius, $cornerRadius);\n    $clearColor = imagecolorallocatealpha($cornerImage, 0, 0, 0, 127);\n    imagefill($cornerImage, 0, 0, $clearColor);\n    $solidColor = imagecolorallocate($cornerImage, 0, 0, 0);\n    \n    imagefilledellipse($cornerImage, $cornerRadius, $cornerRadius, $cornerRadius * 2, $cornerRadius * 2, $solidColor);\n    imagecolortransparent($cornerImage, $solidColor);\n\n    // Apply rounded corners to each corner of the image\n    imagecopymerge($newImage, $image, 0, 0, 0, 0, $width, $height, 100);\n    imagecopymerge($newImage, $cornerImage, 0, 0, 0, 0, $cornerRadius, $cornerRadius, 100);\n    $cornerImage = imagerotate($cornerImage, 90, 0);\n    imagecopymerge($newImage, $cornerImage, 0, $height - $cornerRadius, 0, 0, $cornerRadius, $cornerRadius, 100);\n    $cornerImage = imagerotate($cornerImage, 90, 0);\n    imagecopymerge($newImage, $cornerImage, $width - $cornerRadius, $height - $cornerRadius, 0, 0, $cornerRadius, $cornerRadius, 100);\n    $cornerImage = imagerotate($cornerImage, 90, 0);\n    imagecopymerge($newImage, $cornerImage, $width - $cornerRadius, 0, 0, 0, $cornerRadius, $cornerRadius, 100);\n\n    // Save the new image\n    imagepng($newImage, 'rounded_corners_image.png');\n\n    // Clean up\n    imagedestroy($image);\n    imagedestroy($newImage);\n    imagedestroy($cornerImage);\n}\n\ncreateRoundedCorners('path/to/your/image.png', 20);\n?>