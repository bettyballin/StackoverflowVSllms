use Imagick;\n\n$image = new Imagick('path/to/image.jpg');\n$width = $image->getImageWidth();\n$height = $image->getImageHeight();