$array = [1, 2, 3, 4, 5];\n$firstElement = array_shift($array);\n\necho "Removed Element: $firstElement\n"; // Outputs: Removed Element: 1\nprint_r($array); // Outputs: Array ( [0] => 2 [1] => 3 [2] => 4 [3] => 5 )