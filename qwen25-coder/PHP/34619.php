$imagePath = 'image.jpg';\n$imagick = new Imagick($imagePath);\n\n// Set the copyright information\n$imagick->setImageProperty('Copyright', 'Copyright Initrode');\n\n// Save the image with the new EXIF data\n$imagick->writeImage($imagePath);\n$imagick->clear();\n$imagick->destroy();