$normal_array = array();\n$array_of_arrayrefs = array( &$normal_array );\n\n// Use a variable to hold the reference\n$lastArrayRef = &end($array_of_arrayrefs);\n$lastArrayRef["one"] = 1;\n\nprint_r($normal_array);