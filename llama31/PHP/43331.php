$filesList = '';\nforeach ($files as $filenames) {\n    $filesList .= '<p><a href="./files/'. $filenames['FILENAME'] .'">'. $filenames['FILENAME'] .'</a>' . "\n";\n}