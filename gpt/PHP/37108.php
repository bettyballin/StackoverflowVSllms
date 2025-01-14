function int2coord($i) {\n    $x = $i >> 3;  // Equivalent to dividing by 8\n    $y = $i & 7;   // Equivalent to modulus 8\n    return array($x, $y);\n}\n\n// Example usage\n$coord = int2coord(27); // Returns array(3, 3)