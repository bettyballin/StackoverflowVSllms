<?php\n// Set the content type header\nheader('Content-Type: image/png');\n\n// Create a blank image\n$width = 400;\n$height = 100;\n$image = imagecreatetruecolor($width, $height);\n\n// Allocate colors\n$white = imagecolorallocate($image, 255, 255, 255);\n$black = imagecolorallocate($image, 0, 0, 0);\n\n// Fill the background with white\nimagefilledrectangle($image, 0, 0, $width, $height, $white);\n\n// Set the text and font\n$text = "Underlined Text";\n$font = __DIR__ . '/arial.ttf'; // Ensure you have the font file in the correct path\n$fontSize = 20;\n$x = 10;\n$y = 50;\n\n// Add the text to the image\nimagettftext($image, $fontSize, 0, $x, $y, $black, $font, $text);\n\n// Calculate the text size to draw the underline\n$bbox = imagettfbbox($fontSize, 0, $font, $text);\n$textWidth = $bbox[2] - $bbox[0];\n$underlineY = $y + 5; // Adjust as needed for underline position\n\n// Draw the underline\nimageline($image, $x, $underlineY, $x + $textWidth, $underlineY, $black);\n\n// Output the image\nimagepng($image);\n\n// Free up memory\nimagedestroy($image);\n?>