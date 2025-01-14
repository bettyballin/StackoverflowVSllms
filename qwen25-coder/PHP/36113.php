<?php\n\nfunction generatePyramidStrengths($minStrength = 1.1, $maxStrength = 9.9, $playersTotal = 60000) {\n    $strengthPlayers = [];\n    $totalAssigned = 0;\n    $scaleFactor = pow($maxStrength - $minStrength, 2); // Adjust scale factor as necessary\n\n    for ($s = $minStrength; $s <= $maxStrength; $s += 0.1) {\n        // Using inverse power function to determine number of players\n        $playersForStrength = intval(($scaleFactor / pow($s, 4)) * (rand(8, 12) / 10)); // Random factor for variability\n\n        if ($totalAssigned + $playersForStrength > $playersTotal) {\n            break; // Don't exceed total players number\n        }\n\n        $strengthPlayers[number_format($s, 1)] = $playersForStrength;\n        $totalAssigned += $playersForStrength;\n    }\n\n    // Ensure all players are used, adjust the last strength group if needed\n    if ($totalAssigned < $playersTotal) {\n        end($strengthPlayers);\n        $key = key($strengthPlayers);\n        $strengthPlayers[$key] += $playersTotal - $totalAssigned;\n    }\n\n    return $strengthPlayers;\n}\n\n$pyramidStrengths = generatePyramidStrengths();\nforeach ($pyramidStrengths as $strength => $count) {\n    echo "Strength $strength: $count players\n";\n}