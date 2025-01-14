<?php\n// Create an Imagick object and read images\n$imagick = new Imagick();\n$imagick->readimage('background.png');\n$imagick->readimage('overlay.png');\n\n// Merge the second image as an overlay onto the first\n$imagick->setImageVirtualPixelMethod(Imagick::VIRTUALPIXELMETHOD_TRANSPARENT);\n$imagick->setImageArtifacts(array(\n    'compose:args' => '1,0,-0.5',\n));\n$imagick->compositeImage($imagick->getImage(), Imagick::COMPOSITE_OVER, 0, 0);\n\n// Save the result\n$imagick->writeimage('merged_imagemagick.png');\n\n// Clean up resources\n$imagick->destroy();\n?>