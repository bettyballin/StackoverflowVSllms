<?php\n// Create an image with dimensions 300x100 pixels\n$im = imagecreatetruecolor(300, 100);\n\n// Allocate colors: white background, black text\n$bgColor = imagecolorallocate($im, 255, 255, 255);\n$textColor = imagecolorallocate($im, 0, 0, 0);\n\n// Fill the background with the allocated color\nimagefill($im, 0, 0, $bgColor);\n\n// Write text to the image using a font path and size\n$fontPath = 'path/to/font.ttf';\n$textToDisplay = "Hello, World!";\nimagettftext($im, 24, 0, 10, 70, $textColor, $fontPath, $textToDisplay);\n\n// Output the image as a PNG directly to the browser or save it\nheader('Content-Type: image/png');\nimagepng($im);\n\n// Free up memory\nimagedestroy($im);\n?>