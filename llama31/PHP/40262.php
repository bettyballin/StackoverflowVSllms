$max = filter_input(INPUT_GET, 'max', FILTER_VALIDATE_INT);\n$realMax = getTotalImageCount(); // assume this function returns the total number of images\n\nif ($max === null || $max < 0) {\n    $max = 0;\n} elseif ($max > $realMax) {\n    $max = $realMax;\n}\n\n$min = floor(($max - 1) / 5) * 5; // calculate the nearest multiple of 5 below $max\n\n// Use $min and $max to query and display the images