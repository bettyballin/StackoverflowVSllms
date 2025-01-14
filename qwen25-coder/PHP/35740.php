function tcolorToRgb($tColor) {\n    // Mask out the BGR values and shift them to correct positions\n    $r = ($tColor & 0x0000FF);\n    $g = ($tColor & 0x00FF00) >> 8;\n    $b = ($tColor & 0xFF0000) >> 16;\n    \n    return [$r, $g, $b];\n}\n\n// Example usage:\n$tColorValues = [8388608, 128, 12632256];\n\nforeach ($tColorValues as $color) {\n    $rgb = tcolorToRgb($color);\n    echo "TColor: $color => RGB: (" . implode(", ", $rgb) . ")\n";\n}