<?php\n$array = ["apple", "banana", "cherry", "date", "elderberry", "fig", "grape"];\n\nusort($array, function($a, $b) {\n    return strlen($b) - strlen($a);\n});\n\nprint_r($array);\n?>