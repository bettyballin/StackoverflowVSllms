<?php\n// Load the animated GIF\n$gif = new Imagick('path/to/your/animated.gif');\n\n// This assumes you want to keep the first frame and remove the rest\n$keepFrames = [0]; // Frames to keep (0-indexed)\n\n// Iterate through the frames\nforeach ($gif as $index => $frame) {\n    if (!in_array($index, $keepFrames)) {\n        // Remove the current frame\n        $gif->removeImage();\n    }\n}\n\n// Save the modified GIF\n$gif->writeImages('path/to/your/modified.gif', true);\n\n// Clear the Imagick object\n$gif->clear();\n$gif->destroy();\n?>