<?php\n    // Ensure Imagick is installed and enabled\n    if (!extension_loaded('imagick')) {\n        echo 'Imagick extension is not installed.';\n        exit;\n    }\n\n    // Create a new Imagick object\n    $imagick = new \Imagick();\n\n    // Create two layers\n    $layer1 = new \Imagick();\n    $layer1->newImage(200, 200, new \ImagickPixel('red'));\n    $layer1->setImageFormat('png');\n\n    $layer2 = new \Imagick();\n    $layer2->newImage(200, 200, new \ImagickPixel('blue'));\n    $layer2->setImageFormat('png');\n    \n    // Composite layers\n    $imagick->addImage($layer1);\n    $imagick->addImage($layer2);\n    \n    // Flatten images into a single PNG\n    $flattened = $imagick->flattenImages();\n    \n    // Set the format to PNG\n    $flattened->setImageFormat('png');\n\n    // Output the image\n    header("Content-Type: image/png");\n    echo $flattened;\n\n    // Clear resources\n    $layer1->clear();\n    $layer2->clear();\n    $imagick->clear();\n    ?>