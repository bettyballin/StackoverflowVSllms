<?php\n\n// Function to generate all subsets of a given string\nfunction generateSubsets($input) {\n    $subsets = [];\n    $inputLength = strlen($input);\n\n    // Loop through all combinations\n    for ($i = 0; $i < (1 << $inputLength); $i++) {\n        $subset = '';\n\n        for ($j = 0; $j < $inputLength; $j++) {\n            if ($i & (1 << $j)) {\n                $subset .= $input[$j];\n            }\n        }\n\n        if ($subset !== '') {\n            $subsets[] = $subset;\n        }\n    }\n\n    return $subsets;\n}\n\n// Example dictionary of valid words\n$dictionary = ['rest', 'stare', 'tear', 'rat', 'tar', 'ear', 'are', 'ate', 'tea'];\n\n// Function to find valid sub words from the dictionary\nfunction findValidSubWords($word, $dictionary) {\n    $subsets = generateSubsets($word);\n    $validWords = [];\n\n    foreach ($subsets as $subset) {\n        $sortedSubset = str_split($subset);\n        sort($sortedSubset);\n        $sortedSubset = implode('', $sortedSubset);\n\n        foreach ($dictionary as $dictWord) {\n            $sortedDictWord = str_split($dictWord);\n            sort($sortedDictWord);\n            $sortedDictWord = implode('', $sortedDictWord);\n\n            if ($sortedSubset === $sortedDictWord) {\n                $validWords[] = $dictWord;\n            }\n        }\n    }\n\n    return array_unique($validWords);\n}\n\n// Input word\n$inputWord = 'arrest';\n\n// Find valid sub words\n$validSubWords = findValidSubWords($inputWord, $dictionary);\n\necho 'Valid sub words: ' . implode(', ', $validSubWords);