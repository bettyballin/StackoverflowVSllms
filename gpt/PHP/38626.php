<?php\n$html = '<table border="1"><tr><th>Header 1</th><th>Header 2</th></tr><tr><td>Data 1</td><td>Data 2</td></tr></table>';\n\n// Create a blank image\n$width = 400;\n$height = 200;\n$image = imagecreatetruecolor($width, $height);\n\n// Set background color\n$bgColor = imagecolorallocate($image, 255, 255, 255);\nimagefilledrectangle($image, 0, 0, $width, $height, $bgColor);\n\n// Set text color\n$textColor = imagecolorallocate($image, 0, 0, 0);\n\n// Insert text\nimagettftext($image, 12, 0, 10, 20, $textColor, 'path/to/font.ttf', strip_tags($html));\n\n// Output the image\nheader('Content-Type: image/png');\nimagepng($image);\nimagedestroy($image);\n?>