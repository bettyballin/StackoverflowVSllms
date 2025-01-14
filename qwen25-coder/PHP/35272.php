<?php\n\nfunction getPossibleCombinations($numbers, $letterMap) {\n    // Base case: if numbers string is empty, return an array with an empty string\n    if (empty($numbers)) {\n        return [""];\n    }\n\n    $combinations = [];\n    $firstDigit = $numbers[0];\n    $remainingNumbers = substr($numbers, 1);\n\n    // Get all possible letters for the first digit\n    $possibleLetters = $letterMap[$firstDigit];\n\n    // Recursive call to get combinations of remaining digits\n    $subCombinations = getPossibleCombinations($remainingNumbers, $letterMap);\n\n    // Concatenate each possible letter with each subcombination\n    foreach ($possibleLetters as $letter) {\n        foreach ($subCombinations as $subCombination) {\n            $combinations[] = $letter . $subCombination;\n        }\n    }\n\n    return $combinations;\n}\n\n// Define the mapping of digits to letters\n$numberToLetterMap = [\n    0 => ['N'],\n    1 => ['L'],\n    2 => ['T'],\n    3 => ['D'],\n    4 => ['R'],\n    5 => ['V', 'F'],\n    6 => ['B', 'P'],\n    7 => ['Z'],\n    8 => ['H', 'CH', 'J'],\n    9 => ['G']\n];\n\n// Example usage\n$number = "0123"; // Change this to test other numbers like "051", "89", etc.\n$combinations = getPossibleCombinations($number, $numberToLetterMap);\n\n// Output all combinations\nforeach ($combinations as $combination) {\n    echo $combination . "\n";\n}\n\n?>