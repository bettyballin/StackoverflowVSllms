function resizeImage($input, $output, $maxWidth, $maxHeight) {\n    // Load source image and determine dimensions.\n    list($width, $height) = getimagesize($input);\n    $ratio = min($maxWidth / $width, $maxHeight / $height);\n\n    // Calculate new dimensions while maintaining aspect ratio.\n    $newWidth = (int) ($width * $ratio);\n    $newHeight = (int) ($height * $ratio);\n\n    // Create a new image with the new dimensions.\n    $newImage = imagecreatetruecolor($newWidth, $newHeight);\n    $sourceImage = imagecreatefromjpeg($input);  // Assuming JPEG, change accordingly.\n\n    // Resample the source image to fit into the new dimensions.\n    if (!imagecopyresampled($newImage, $sourceImage, 0, 0, 0, 0, $newWidth, $newHeight, $width, $height)) {\n        return false;\n    }\n\n    // Apply an unsharp mask to sharpen the image.\n    if (!unsharpmask($newImage, 50, 128, 7)) {  // Adjust parameters as needed.\n        return false;\n    }\n\n    // Save the resized and sharpened image.\n    if (!imagejpeg($newImage, $output)) {\n        return false;\n    }\n\n    imagedestroy($newImage);\n    imagedestroy($sourceImage);\n\n    return true;\n}\n\nfunction unsharpmask(&$img, $amount, $radius, $threshold) {\n    // Create a mask and apply sharpening filter.\n    if (($width = imagesx($img)) && ($height = imagesy($img))) {\n        $rgbThreshold = isset($threshold) ? $threshold : 0;\n        $matrix = array(\n            array(-1,-1,-1),\n            array(-1, 9,-1),\n            array(-1,-1,-1)\n        );\n        $divisor = array_sum(array_map('array_sum', $matrix));\n        if (!$divisor) {\n            $divisor = 1;\n        }\n        $stencil = abs($divisor);\n\n        $steps = ceil($radius * 2.54);\n        $_img = imagecreate($width, $height);\n        if (!$_img) return false;\n\n        for ($i = 0; $i < $steps; $i++) {\n            imagefilter($_img, IMG_FILTER_CONVOLVE_3x3, array(\n                -1, -1, -1,\n                -1, 8,-1,\n                -1, -1, -1\n            ), $amount);\n        }\n\n        return imagecopymerge($img, $_img, 0, 0, 0, 0, $width, $height, $stencil);\n    }\n    return false;\n}\n\n// Usage example.\nresizeImage("input.jpg", "output.jpg", 800, 600);