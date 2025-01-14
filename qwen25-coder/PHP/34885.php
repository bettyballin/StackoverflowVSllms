<?php\nheader('Content-type: image/jpeg');\n\n// Load the source image\n$im = imagecreatefromjpeg('test.jpg');\nif (!$im) {\n    die('Cannot load JPEG.');\n}\n\n// Create a new true color image to work with\n$newIm = imagecreatetruecolor(imagesx($im), imagesy($im));\n\n// Thresholds for identifying light pixels (which you want to turn black)\n$lightThreshold = 200; // Adjust this value as needed\n\nfor ($x = 0; $x < imagesx($im); $x++) {\n    for ($y = 0; $y < imagesy($im); $y++) {\n        // Get the color at a pixel\n        $rgb = imagecolorat($im, $x, $y);\n\n        // Extract r, g, b from the rgb value\n        $r = ($rgb >> 16) & 0xFF;\n        $g = ($rgb >> 8) & 0xFF;\n        $b = $rgb & 0xFF;\n\n        // Check if the pixel is light (close to white)\n        if ($r > $lightThreshold && $g > $lightThreshold && $b > $lightThreshold) {\n            // Set pixel color to black\n            $newColor = imagecolorallocate($newIm, 0, 0, 0);\n        } else {\n            // Otherwise, set the original color\n            $newColor = imagecolorallocate($newIm, $r, $g, $b);\n        }\n\n        // Set the pixel with new color in the new image\n        imagesetpixel($newIm, $x, $y, $newColor);\n    }\n}\n\n// Colorize the rest of the image to your desired shade (orange in this case)\nimagefilter($newIm, IMG_FILTER_COLORIZE, 252, 137, 36);\n\n// Output to browser\nimagejpeg($newIm);\n\n// Free up memory\nimagedestroy($im);\nimagedestroy($newIm);\n?>