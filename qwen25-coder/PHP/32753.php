function getRandomStrength($quality, $min = 1.5, $max = 8.0) {\n    $rand = mt_rand() / mt_getrandmax();\n    // Calculate the original value between 1 and 9 (or any other base range)\n    $originalValue = pow(M_E, ($rand - 1.033) / -0.45);\n    // Scale this value to the new desired range\n    $scaledValue = (($originalValue - 1) / 8) * ($max - $min) + $min;\n    return round($scaledValue, 1);\n}