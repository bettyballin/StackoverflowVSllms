// Content type\nheader('Content-type: image/jpeg');\n\n// Resize\nimagecopyresized($thumb, $source, 0, 0, 0, 0, $newwidth, $newheight, $width, $height);\n\n// Output\nimagejpeg($thumb);