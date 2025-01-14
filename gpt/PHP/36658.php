<?php\nfunction createReflection($srcImagePath, $outputImagePath, $reflectionHeight) {\n    // Load the source image\n    $srcImage = imagecreatefromjpeg($srcImagePath);\n    $width = imagesx($srcImage);\n    $height = imagesy($srcImage);\n\n    // Create the reflection image\n    $reflection = imagecreatetruecolor($width, $reflectionHeight);\n    imagealphablending($reflection, false);\n    imagesavealpha($reflection, true);\n    $transColor = imagecolorallocatealpha($reflection, 0, 0, 0, 127);\n    imagefill($reflection, 0, 0, $transColor);\n\n    // Copy the source image into the reflection image\n    for ($y = 0; $y < $reflectionHeight; $y++) {\n        imagecopy($reflection, $srcImage, 0, $y, 0, $height - $y - 1, $width, 1);\n    }\n\n    // Apply the alpha layers\n    for ($y = 0; $y < $reflectionHeight; $y++) {\n        $alpha = 127 * ($y / $reflectionHeight);\n        for ($x = 0; $x < $width; $x++) {\n            $color = imagecolorat($reflection, $x, $y);\n            $rgba = imagecolorsforindex($reflection, $color);\n            $newColor = imagecolorallocatealpha($reflection, $rgba['red'], $rgba['green'], $rgba['blue'], $alpha);\n            imagesetpixel($reflection, $x, $y, $newColor);\n        }\n    }\n\n    // Create the final image\n    $finalImage = imagecreatetruecolor($width, $height + $reflectionHeight);\n    imagealphablending($finalImage, false);\n    imagesavealpha($finalImage, true);\n    $transColor = imagecolorallocatealpha($finalImage, 0, 0, 0, 127);\n    imagefill($finalImage, 0, 0, $transColor);\n\n    // Copy the source image and reflection into the final image\n    imagecopy($finalImage, $srcImage, 0, 0, 0, 0, $width, $height);\n    imagecopy($finalImage, $reflection, 0, $height, 0, 0, $width, $reflectionHeight);\n\n    // Save the final image\n    imagepng($finalImage, $outputImagePath);\n\n    // Clean up\n    imagedestroy($srcImage);\n    imagedestroy($reflection);\n    imagedestroy($finalImage);\n}\n\n// Usage\ncreateReflection('your-image.jpg', 'output-image.png', 100);\n?>