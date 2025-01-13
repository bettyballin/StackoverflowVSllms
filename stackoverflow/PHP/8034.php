<?php\n// Score: 1\necho pronounceability('namelet') . "\n";\n\n// Score: 0.71428571428571\necho pronounceability('nameoic') . "\n";\n\nfunction pronounceability($word) {\n    static $vowels = array\n        (\n        'a',\n        'e',\n        'i',\n        'o',\n        'u',\n        'y'\n        );\n\n    static $composites = array\n        (\n        'mm',\n        'll',\n        'th',\n        'ing'\n        );\n\n    if (!is_string($word)) return false;\n\n    // Remove non letters and put in lowercase\n    $word = preg_replace('/[^a-z]/i', '', $word);\n    $word = strtolower($word);\n\n    // Special case\n    if ($word == 'a') return 1;\n\n    $len = strlen($word);\n\n    // Let's not parse an empty string\n    if ($len == 0) return 0;\n\n    $score = 0;\n    $pos = 0;\n\n    while ($pos < $len) {\n        // Check if is allowed composites\n        foreach ($composites as $comp) {\n            $complen = strlen($comp);\n\n            if (($pos + $complen) < $len) {\n                $check = substr($word, $pos, $complen);\n\n                if ($check == $comp) {\n                    $score += $complen;\n                    $pos += $complen;\n                    continue 2;\n                }\n            }\n        }\n\n        // Is it a vowel? If so, check if previous wasn't a vowel too.\n        if (in_array($word[$pos], $vowels)) {\n            if (($pos - 1) >= 0 && !in_array($word[$pos - 1], $vowels)) {\n                $score += 1;\n                $pos += 1;\n                continue;\n            }\n        } else { // Not a vowel, check if next one is, or if is end of word\n            if (($pos + 1) < $len && in_array($word[$pos + 1], $vowels)) {\n                $score += 2;\n                $pos += 2;\n                continue;\n            } elseif (($pos + 1) == $len) {\n                $score += 1;\n                break;\n            }\n        }\n\n        $pos += 1;\n    }\n\n    return $score / $len;\n}