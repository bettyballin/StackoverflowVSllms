$imageDir = "/path/to/images/dir/";\n$imagePath = "$imageDir$pk.jpg";\nif (!is_dir($imageDir) or !is_writable($imageDir)) {\n    // Error if directory doesn't exist or isn't writable.\n} elseif (is_file($imagePath) and !is_writable($imagePath)) {\n    // Error if the file exists and isn't writable.\n}\n\n$image = file_get_contents(urlencode($PIC_URL));\nif (empty($image)) {\n    // Error if the image is empty/not accessible.\n    exit;\n}\n\nfile_put_contents($imagePath, $image);