$image = imagecreatefrompng($outputFile);\n$thumbnailWidth = 200;\n$thumbnailHeight = 150;\nimagecopyresampled($image, $image, 0, 0, 0, 0, $thumbnailWidth, $thumbnailHeight, imagesx($image), imagesy($image));\nimagepng($image, 'thumbnail.png');\nimagedestroy($image);