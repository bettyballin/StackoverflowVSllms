$files = scandir('Images');\nsort($files);\n\nforeach ($files as $file) {\n    if ($file != "." && $file != ".." && $file != "index.php" && $file != "Thumbnails") {\n        $crap   = array(".jpg", ".jpeg", ".JPG", ".JPEG", ".png", ".PNG", ".gif", ".GIF", ".bmp", ".BMP", "_", "-");    \n        $newstring = str_replace($crap, " ", $file );   \n        echo "<li><a href=\"Images/$file\" class=\"thickbox\" rel=\"gallery\" title=\"$newstring\"><img src=\"Images/Thumbnails/$file\" alt=\"$newstring\" width=\"300\"  </a></li>\n";\n    }\n}