<?php\n$imagePath = 'path/to/original/image.jpg';\n$thumbnailWidth = 200;\n$thumbnailHeight = 200;\n\n$image = imagecreatefromjpeg($imagePath);\n$thumbnail = imagecreatetruecolor($thumbnailWidth, $thumbnailHeight);\nimagecopyresampled($thumbnail, $image, 0, 0, 0, 0, $thumbnailWidth, $thumbnailHeight, imagesx($image), imagesy($image));\nheader('Content-Type: image/jpeg');\nimagejpeg($thumbnail);\nimagedestroy($thumbnail);\nimagedestroy($image);\n?>