function packRatings($ratings) {\n    $packed = 0;\n    for ($i = 0; $i < count($ratings); $i++) {\n        $packed |= ($ratings[$i] & 0x7) << (3 * $i); // 0x7 is binary 111 to mask 3 bits\n    }\n    return $packed;\n}\n\nfunction unpackRatings($packed) {\n    $ratings = [];\n    for ($i = 0; $i < 5; $i++) {\n        $ratings[] = ($packed >> (3 * $i)) & 0x7;\n    }\n    return $ratings;\n}\n\n// Example usage:\n$ratings = [3, 5, 2, 4, 1];\n$packed = packRatings($ratings);\necho "Packed: " . $packed . "\n";\n\n$unpacked = unpackRatings($packed);\necho "Unpacked: " . implode(", ", $unpacked) . "\n";