$letters = array('a', 'b', 'c');\n\nforeach($letters as $letter) {\n    ${$letter} = array();\n}\n\n// Now you have three empty arrays: $a, $b, $c\nprint_r($a);\nprint_r($b);\nprint_r($c);