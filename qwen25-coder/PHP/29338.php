<?php\nfunction convertToBlackAndWhite($inputImagePath, $outputImagePath, $threshold = 128) {\n    // Load the image into memory\n    $image = imagecreatefromjpeg($inputImagePath);\n    \n    if (!$image) {\n        die("Unable to load image");\n    }\n\n    // Get the dimensions of the image\n    $width = imagesx($image);\n    $height = imagesy($image);\n\n    // Loop through each pixel and convert it to black or white\n    for ($y = 0; $y < $height; $y++) {\n        for ($x = 0; $x < $width; $x++) {\n            $rgb = imagecolorat($image, $x, $y);\n\n            // Extract the red, green, and blue values from the pixel\n            $r = ($rgb >> 16) & 0xFF;\n            $g = ($rgb >> 8) & 0xFF;\n            $b = $rgb & 0xFF;\n\n            // Calculate the luminance using a common formula\n            $luminance = (int)(($r * 0.299) + ($g * 0.587) + ($b * 0.114));\n\n            // Set the pixel to black or white based on the threshold\n            if ($luminance > $threshold) {\n                $newColor = imagecolorallocate($image, 255, 255, 255); // White\n            } else {\n                $newColor = imagecolorallocate($image, 0, 0, 0); // Black\n            }\n\n            imagesetpixel($image, $x, $y, $newColor);\n        }\n    }\n\n    // Save the new black and white image\n    imagejpeg($image, $outputImagePath);\n\n    // Free up memory\n    imagedestroy($image);\n}\n\n// Example usage:\nconvertToBlackAndWhite('input.jpg', 'output_bw.jpg');\n?>