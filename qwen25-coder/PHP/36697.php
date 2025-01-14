foreach ($imagePaths as $path) {\n    // Extract the file name from the path\n    $fileNameWithExtension = basename($path);\n    \n    // Remove the extension from the filename\n    $fileNameWithoutExtension = pathinfo($fileNameWithExtension, PATHINFO_FILENAME);\n    \n    // Replace underscores with spaces\n    $formattedFileName = str_replace('_', ' ', $fileNameWithoutExtension);\n    \n    // Output the formatted file name or use it in your <img> tag\n    echo "<img src='$path' alt='$formattedFileName'>";\n}